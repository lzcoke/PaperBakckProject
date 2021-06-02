package com.lzcoke.paper.pojo;

import lombok.Data;

import java.util.List;

@Data
public class AdminUser {
    private int adminUserId;
    private String name;
    private String avatar;
    private String username;
    private int status;
    private String roles;
    private String[] rolesList;
}
