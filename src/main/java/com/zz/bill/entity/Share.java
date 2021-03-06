package com.zz.bill.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Share {

    @Id
    @GeneratedValue
    Integer shareID;

    Integer spendID;

    Integer userID;

    BigDecimal amount;

    BigDecimal shouldPay;
    BigDecimal shouldReceive;

    Timestamp createdAt;
    Timestamp updatedAt;

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

    public Share() {
    }
}
