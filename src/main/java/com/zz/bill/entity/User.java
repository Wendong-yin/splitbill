package com.zz.bill.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer uid;

    // ❤️ 这个 account 应该是惟一的，因为很多时候用户不记得 ID，只知道自己的 account
    private String account;

    private String nickName;
    // TODO 之后要修改这个密码设置，现在暂时测试一下逻辑
    private String password;

    private String authToken;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
