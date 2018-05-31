package com.zz.bill.model.account;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Data
@Entity
public class UserInfo {

    @Id
    @GeneratedValue
    private Integer uid;

    private String nickName;
    private String account;
    private String authToken;
    private Timestamp createdAt;
    private Timestamp updatedAt;


    @PrePersist
    public void prePresist(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        createdAt = timestamp;
        updatedAt = timestamp;
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = new Timestamp(System.currentTimeMillis());
    }


}
