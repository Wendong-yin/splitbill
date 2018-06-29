package com.zz.bill.model.token;

import lombok.Data;

@Data
public class TokenModel {
    // 用户 id
    private Integer userId;

    // 存储随机生成的 uuid
    private String token;

    public TokenModel(Integer userId, String token) {
        this.userId = userId;
        this.token = token;
    }
}
