package com.zz.bill.service;

import com.zz.bill.entity.Result;
import com.zz.bill.model.calculator.CalculateResult;
import com.zz.bill.model.calculator.FinalTransfer;

import java.util.List;

public interface ICalculatorService {
//    CalculatorResult calculateResult(Integer userID, Integer eventId);
    public List<CalculateResult> calculate(List<Integer> uids, Integer eventId);


    public List<Result> finalResult(List<CalculateResult> totalResult , Integer eventID);
}
