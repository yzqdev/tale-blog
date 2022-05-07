package com.yzq.talespring.service.impl;

import com.baomidou.mybatisplus.annotation.OrderBy;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzq.talespring.mapper.ContentsMapper;
import com.yzq.talespring.model.dto.Types;
import com.yzq.talespring.model.entity.Contents;
import com.yzq.talespring.service.ContentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.desktop.QuitEvent;
import java.util.List;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/23 13:13
 * @modified By:
 */
@Service
public class ContentsServiceImpl extends ServiceImpl<ContentsMapper, Contents> implements ContentsService {
    @Resource
    ContentsMapper contentsMapper;
    @Override
    public List<Contents> getIndexContents(String type, int limit) {
        if (limit < 0 || limit > 20) {
            limit = 10;
        }

        // 最新文章
        if (Types.RECENT_ARTICLE.equals(type)) {
            QueryWrapper<Contents> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("status", Types.PUBLISH);
            queryWrapper.eq("type", Types.ARTICLE);
            queryWrapper.orderByDesc("created");
             Page<Contents> contentsPage=contentsMapper.selectPage(new Page<>(),queryWrapper) ;
            //Page<Contents> contentsPage = select().from(Contents.class)
            //        .where(Contents::getStatus, Types.PUBLISH)
            //        .and(Contents::getType, Types.ARTICLE)
            //        .order(Contents::getCreated, OrderBy.DESC)
            //        .page(1, limit);

            return contentsPage.getRecords();
        }
        return null;
    }
}
