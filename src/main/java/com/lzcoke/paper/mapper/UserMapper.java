package com.lzcoke.paper.mapper;

import com.lzcoke.paper.pojo.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    List<User> userList(int startIndex, int pageSize);

    @Update("update user set block = 1 where user_id = #{userId}")
    int userBlocking(int userId);

    @Update("update user set block = 0 where user_id = #{userId}")
    int userCancelBlocking(int userId);

    @Update("update user set password = #{password} where user_id = #{userId}")
    int userUpdatePassword(int userId, String password);

    int createUser(User user);

    User getUser(User user);
}
