package com.zz.bill.model.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpendCalculatorResult {
    private String des;
    private BigDecimal prepay;
    private BigDecimal share;



}
