package com.lzcoke.paper.controller;

import com.lzcoke.paper.pojo.User;
import com.lzcoke.paper.service.UserService;
import com.lzcoke.paper.utils.result.ResultUtils;
import com.lzcoke.paper.vo.UserPassVo;
import com.lzcoke.paper.vo.UserBlockVo;
import com.lzcoke.paper.vo.UserVo;
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
    public ResultUtils userBlock(@RequestBody UserBlockVo user) {
        Map<String, Object> map = new HashMap<>();
        int i = userService.userBlocking(user.getUserId());
        if (i > 0) {
            return ResultUtils.success(map);
        } else {
            return ResultUtils.error("网络错误");
        }
    }

    @PutMapping("/userBlock")
    @ApiOperation("解冻用户")
    public ResultUtils userCancelBlock(@RequestBody UserBlockVo user) {
        Map<String, Object> map = new HashMap<>();
        int i = userService.userCancelBlocking(user.getUserId());
        if (i > 0) {
            return ResultUtils.success(map);
        } else {
            return ResultUtils.error("网络错误");
        }
    }

    @PutMapping("/password")
    @ApiOperation("修改密码")
    public ResultUtils userPassword(@RequestBody UserPassVo user) {
        Map<String, Object> map = new HashMap<>();
        int i = userService.userPassword(user.getUserId(), user.getPassword());
        if (i > 0) {
            return ResultUtils.success(map);
        } else {
            return ResultUtils.error("网络错误");
        }
    }

    @PostMapping("/user")
    @ApiOperation("创建用户")
    public ResultUtils createUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        User user1 = new User();
        user1.setEmail(user.getEmail());
        System.out.println(user1);
        User user2 = userService.getUser(user1);
        if (user2 == null) {
            int i = userService.createUser(user);
            if (i > 0) {
                return ResultUtils.success(map);
            } else {
                return ResultUtils.error("网络错误");
            }
        } else {
            return ResultUtils.error("邮箱重复");
        }
    }
}
