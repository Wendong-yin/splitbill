package com.zz.bill.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Data
public class Spend {
    @Id
    @GeneratedValue
    private Integer spendId;

    private Integer eventId;
    private String SpendName;
    private String desc;

    @NotNull(message = "必须输入金额")
    private BigDecimal amount;

    @NotNull(message = "prepay 用户 id 不能为空")
    private Integer prepayUserID;

    private Timestamp createdAt;
    private Timestamp updatedAt;


}
