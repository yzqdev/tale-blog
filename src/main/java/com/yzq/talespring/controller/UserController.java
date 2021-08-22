package com.yzq.talespring.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzq.talespring.mapper.UserMapper;
import com.yzq.talespring.model.entity.User;
import com.yzq.talespring.utils.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/22 21:48
 * @modified By:
 */
@RestController
@RequestMapping("/admin")
public class UserController {
    @Resource
    UserMapper userMapper;

    @GetMapping("/users")
    public CommonResult getUsers() {
        List<User> users = userMapper.selectList(new QueryWrapper<>());

        return CommonResult.success(users);
    }
}
