package com.zz.bill.model.calculator;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CalculateResult {
    private Integer uid;
    private BigDecimal totalReceive;
    private BigDecimal totalPay;
    private BigDecimal totalResult;
}
