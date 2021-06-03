package com.lzcoke.paper.controller;

import com.lzcoke.paper.pojo.User;
import com.lzcoke.paper.service.LoginService;
import com.lzcoke.paper.service.UserService;
import com.lzcoke.paper.utils.result.ResultUtils;
import com.lzcoke.paper.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation("获取用户列表")
    public ResultUtils userList(@RequestParam String name,
                                @RequestParam String number,
                                @RequestParam String email,
                                @RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "10") int limit) {
        List<User> users = userService.userList(page, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("total", users.size());
        map.put("list", users);
        return ResultUtils.success(map);
    }

    @PostMapping("/userBlock")
    @ApiOperation("冻结用户")
    public ResultUtils userBlock(@RequestBody UserVo user) {
        Map<String, Object> map = new HashMap<>();
        int i = userService.userBlocking(user.getUserId());
        if (i > 0) {
            return ResultUtils.success(map);
        } else {
            return ResultUtils.error("网络错误");
        }
    }
}
