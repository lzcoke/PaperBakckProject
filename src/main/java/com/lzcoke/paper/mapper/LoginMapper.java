package com.lzcoke.paper.mapper;

import com.lzcoke.paper.pojo.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LoginMapper {

    @Select("select * from admin_user where username = #{username} and password = #{password} and status = 0")
    AdminUser loginAdminUser(String username, String password);

    @Select("select * from admin_user where admin_user_id = #{adminUserId}")
    AdminUser adminUserInfo(int adminUserId);
}
