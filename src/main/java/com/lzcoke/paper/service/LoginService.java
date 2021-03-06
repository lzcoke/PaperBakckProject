package com.lzcoke.paper.service;

import com.lzcoke.paper.mapper.LoginMapper;
import com.lzcoke.paper.pojo.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    /*登录*/
    @Autowired
    private LoginMapper LoginMapper;

    public AdminUser login(String username, String password) {
        System.out.println(password);
        return LoginMapper.loginAdminUser(username, password);
    }

    public AdminUser userinfo(int adminUserId) {
        AdminUser adminUser = LoginMapper.adminUserInfo(adminUserId);
        String[] split = adminUser.getRoles().split(",");
        adminUser.setRolesList(split);
        return adminUser;
    }
}
