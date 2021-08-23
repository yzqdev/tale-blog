package com.yzq.talespring.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.yzq.talespring.bootstrap.TaleConst;
import com.yzq.talespring.mapper.LogsMapper;
import com.yzq.talespring.mapper.UserMapper;
import com.yzq.talespring.model.entity.Logs;
import com.yzq.talespring.model.entity.User;
import com.yzq.talespring.service.SiteService;
import com.yzq.talespring.service.UserService;
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
public class SiteServiceImpl implements SiteService {
    @Resource
    UserService userService;
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
            lock.createNewFile();
            TaleConst.INSTALLED = Boolean.TRUE;
            Logs logs = new Logs("初始化站点", null, "", uid);
            logsMapper.insert(logs);
        } catch (Exception e) {
            try {
                throw new Exception("初始化站点失败");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
