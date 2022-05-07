package com.yzq.talespring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzq.talespring.mapper.UserMapper;
import com.yzq.talespring.model.entity.User;
import com.yzq.talespring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yzq
 * @description
 * @date:Created time 2021/8/22 21:43
 * @modified By:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    UserMapper userMapper;

}
