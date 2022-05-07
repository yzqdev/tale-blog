package com.yzq.talespring.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yzq.talespring.model.entity.Comments;
import com.yzq.talespring.model.entity.Logs;
import com.yzq.talespring.service.CommentsService;
import com.yzq.talespring.service.LogsService;
import com.yzq.talespring.utils.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yangzhengqian
 * @description
 * @date:Created time 2021/8/23 13:36
 * @modified By:
 */
@RestController
@RequestMapping("/admin/api")
public class AdminController {
    @Resource
    CommentsService commentsService;
    @Resource
    LogsService logsService;

    @GetMapping("/comments")
    public CommonResult getComments() {
        List<Comments> commentsList = commentsService.list();
        return CommonResult.success(commentsList);
    }

    @GetMapping("/logs")
    public CommonResult getLogs(@RequestParam("page") long page, @RequestParam("limit") long limit) {
        Page<Logs> logsPage= new Page<>(page, limit);
      IPage<Logs> logs= logsService.page(logsPage);
        return CommonResult.success(logs);
    }
}

