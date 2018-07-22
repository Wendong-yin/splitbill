package com.zz.bill.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CalculatorResult {
    private BigDecimal prepay;
    private BigDecimal share;


}
