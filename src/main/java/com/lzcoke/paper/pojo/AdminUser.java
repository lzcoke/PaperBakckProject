package com.lzcoke.paper.pojo;

import lombok.Data;

@Data
public class AdminUser {
    private int adminUserId;
    private String name;
    private String avatar;
    private int status;
    private String role;
}
