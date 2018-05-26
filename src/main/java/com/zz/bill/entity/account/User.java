package com.zz.bill.entity.account;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {

    private Integer id;
    private String account;
    private String nickName;
    private String pwd;
    private String avatar;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
