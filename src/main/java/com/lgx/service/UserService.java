package com.lgx.service;

import com.lgx.entity.User;
import com.lgx.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    // 登录：根据用户名查用户
    public User login(String username) {
        return userMapper.selectByUsername(username);
    }
}