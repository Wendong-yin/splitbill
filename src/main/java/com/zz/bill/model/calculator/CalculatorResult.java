package com.zz.bill.model.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorResult {
    private BigDecimal prepay;
    private BigDecimal share;

    List<SpendCalculatorResult> spendResult;


}
