package com.lzcoke.paper.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int userId;
    private String nickname;
    private String avatar;
    private String email;
    private String school;
    private String prov;
    private String city;
    private int sex;
    private int block;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
}
