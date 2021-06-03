package com.lzcoke.paper.service;

import com.lzcoke.paper.mapper.UserMapper;
import com.lzcoke.paper.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> userList(int page, int limit) {
        int startIndex = (page - 1) * limit;
        return userMapper.userList(startIndex, limit);
    }

    public int userBlocking(int userId){
        int i = userMapper.userBlocking(userId);
        return i;

    }

}
