package com.lzcoke.paper.controller;

import com.lzcoke.paper.pojo.AdminUser;
import com.lzcoke.paper.service.LoginService;
import com.lzcoke.paper.utils.redis.RedisUtils;
import com.lzcoke.paper.utils.result.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backend/v1")
public class AdminUserController {

    private final LoginService loginService;

    @Autowired
    public AdminUserController(LoginService loginService) {
        this.loginService = loginService;
    }

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/userInfo")
    public ResultUtils adminUser(@RequestParam int token) {
        AdminUser userinfo = loginService.userinfo(token);
        if (userinfo == null) {
            return ResultUtils.error("token已过期");
        } else {
            return ResultUtils.success(userinfo);
        }
    }
}
