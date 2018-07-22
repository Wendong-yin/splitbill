package com.zz.bill.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@Builder
public class Share {

    @Id
    @GeneratedValue
    Integer shareID;

    Integer spendID;

    Integer userID;

    BigDecimal amount;

    BigDecimal shouldPay;
    BigDecimal shouldReceive;

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
