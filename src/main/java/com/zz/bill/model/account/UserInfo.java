package com.zz.bill.model.account;

import lombok.Data;

@Data
public class UserInfo {
    private Integer uid;
    private String nickName;
    private String account;
    private String authToken;
}
