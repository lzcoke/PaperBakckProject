package com.lzcoke.paper.mapper;

import com.lzcoke.paper.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    List<User> userList(int startIndex, int pageSize);
}
