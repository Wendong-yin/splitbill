package com.zz.bill.model.calculator;

import com.zz.bill.entity.Result;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

@Data
public class FinalTransfer {
    public Integer uid;
    public BigDecimal totalResult;

    @Override
    public String toString() {
        return uid +  " : " + totalResult.toString();
    }

    public FinalTransfer(Integer uid, Double totalResult) {
        this.uid = uid;
        this.totalResult = new BigDecimal(totalResult);
    }


    public static void main(String[] args) {
    }
}
