package com.lzcoke.paper.controller;

import com.lzcoke.paper.pojo.AdminUser;
import com.lzcoke.paper.service.LoginService;
import com.lzcoke.paper.utils.redis.RedisUtils;
import com.lzcoke.paper.utils.result.ResultUtils;
import com.lzcoke.paper.vo.LoginVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@ApiOperation(value = "登录接口")
@RequestMapping("/backend/v1")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResultUtils login(@RequestBody LoginVo loginVo) {
        final AdminUser login = loginService.login(loginVo.getUsername(), loginVo.getPassword());
        if (login == null) {
            return ResultUtils.error("账号或者密码错误");
        } else {
            redisUtils.set("admin_token_" + login.getAdminUserId(), login);
            Map<String, Object> map = new HashMap<>();
            map.put("token", login.getAdminUserId());
            map.put("user", login);
            return ResultUtils.success(map);
        }
    }

    @GetMapping("/loginIO")
    public ResultUtils loginio() {
        return ResultUtils.error("账号或者密码错误!");
    }
}
