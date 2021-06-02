package com.lzcoke.paper.controller;

import com.lzcoke.paper.pojo.User;
import com.lzcoke.paper.service.LoginService;
import com.lzcoke.paper.service.UserService;
import com.lzcoke.paper.utils.result.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/backend/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResultUtils userList(@RequestParam String name,
                                @RequestParam String number,
                                @RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "10") int limit) {
        List<User> users = userService.userList(page, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("total", users.size());
        map.put("list", users);
        return ResultUtils.success(map);
    }
}
