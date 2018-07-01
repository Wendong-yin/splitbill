package com.zz.bill.model.account;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class UserInfo {

    private Integer id;
    private String account;
    private String token;
}
