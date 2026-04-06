package com.lgx.controller;

import com.lgx.common.Result;
import com.lgx.entity.User;
import com.lgx.service.UserService;
import com.lgx.util.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<String> login(@RequestParam String username,
                                @RequestParam String password) {

        User user = userService.login(username);

        if (user == null) {
            return Result.error("用户不存在");
        }

        if (password.equals(user.getPassword())) {
            // 生成 token
            String token = JwtUtil.createToken(username);
            return Result.success("登录成功：" + token);
        } else {
            return Result.error("密码错误");
        }
    }
}