package com.zz.bill.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Data
@DynamicUpdate
public class Spend {

    @GeneratedValue
    @Id
    private Integer spendId;

    private Integer eventId;
    private String spendName;
    private String description;

    @NotNull(message = "必须输入金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "是谁先垫付了这个 spend，传入他的 id")
    @NotNull(message = "prepay 用户 id 不能为空")
    private Integer prepayUserID;

    private String status;

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
