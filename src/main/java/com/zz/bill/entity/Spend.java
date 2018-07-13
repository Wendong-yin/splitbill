package com.zz.bill.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Timestamp;


//@DynamicUpdate
//@Entity
//@Data
public class Spend {
    private Integer spendId;
    private Integer eventId;
    private String SpendName;
    private String desc;
    private BigDecimal amount;

    private Integer prepayUserID;

    private Timestamp createdAt;
    private Timestamp updatedAt;


}
