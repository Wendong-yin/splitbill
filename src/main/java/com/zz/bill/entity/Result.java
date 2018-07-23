package com.zz.bill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Result {

    @Id
    @GeneratedValue
    private Integer ResultID;
    private Integer eventID;

    private Integer fromUserID;
    private Integer toUserID;

    private BigDecimal amount;

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



    public Result(Integer fromUserID, Integer toUserID, BigDecimal amount) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return
                "form:" + fromUserID +
                " to" + toUserID +
                " " + amount;
    }
}
