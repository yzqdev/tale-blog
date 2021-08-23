package com.yzq.talespring.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzq.talespring.bootstrap.TaleConst;
import com.yzq.talespring.mapper.LogsMapper;
import com.yzq.talespring.mapper.UserMapper;
import com.yzq.talespring.model.dto.Statistics;
import com.yzq.talespring.model.dto.Types;
import com.yzq.talespring.model.entity.Contents;
import com.yzq.talespring.model.entity.Logs;
import com.yzq.talespring.model.entity.Metas;
import com.yzq.talespring.model.entity.User;
import com.yzq.talespring.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.sql.Timestamp;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/23 9:38
 * @modified By:
 */
@Service
@Slf4j
public class SiteServiceImpl implements SiteService {
    @Resource
    UserService userService;
    @Resource
    ContentsService contentsService;
    @Resource
    CommentsService commentsService;
    @Resource
    AttachService attachService;
    @Resource
    MetasService metasService;
    @Resource
    LogsMapper logsMapper;

    @Override
    public void initSite(User user) {
        String pwd = MD5.create().digestHex(user.getUsername() + user.getPassword());
        user.setPassword(pwd);
        user.setScreenName(user.getUsername());
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        userService.save(user);
        Integer uid = user.getUid();
        try {
            String cp = UserMapper.class.getClassLoader().getResource("").getPath();
            File lock = new File(cp + "install.lock");
            log.info(lock.getAbsolutePath());
            lock.createNewFile();
            TaleConst.INSTALLED = Boolean.TRUE;
            Logs logs = new Logs("初始化站点", null, "", uid);
            logsMapper.insert(logs);
        } catch (Exception e) {
            try {
                e.printStackTrace();
                throw new Exception("初始化站点失败");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Statistics getStatistics() {
        Statistics statistics = new Statistics();

        long articles = contentsService.count(new QueryWrapper<Contents>().eq("type", Types.ARTICLE).eq("status", Types.PUBLISH));
        long pages = contentsService.count(new QueryWrapper<Contents>().eq("type", Types.PAGE).eq("status", Types.PUBLISH));
        long comments = commentsService.count();
        long attachs = attachService.count();
        long tags = metasService.count(new QueryWrapper<Metas>().eq("type", Types.TAG));
        long categories = metasService.count(new QueryWrapper<Metas>().eq("type", Types.CATEGORY));
        statistics.setArticles(articles);
        statistics.setPages(pages);
        statistics.setComments(comments);
        statistics.setAttachs(attachs);
        statistics.setTags(tags);
        statistics.setCategories(categories);
        return statistics;
    }
}
