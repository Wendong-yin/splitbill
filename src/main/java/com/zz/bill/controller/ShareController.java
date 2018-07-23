package com.zz.bill.controller;

import com.zz.bill.entity.Result;
import com.zz.bill.model.JsonResult;
import com.zz.bill.model.calculator.CalculateResult;
import com.zz.bill.service.ICalculatorService;
import com.zz.bill.service.share.IShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/share")
public class ShareController {

    @Autowired
    IShareService shareService;

    @Autowired
    ICalculatorService calculatorService;

    @PostMapping(value = "/add")
    JsonResult addShare(@RequestParam List<Integer> users, @RequestParam Integer eventID){
        return shareService.addShare(users, eventID);
    }

    @GetMapping(value = "/test")
    JsonResult test(){
        List<Integer> uid = Arrays.asList(1,2,3,4,5,6);
        Integer eventID  =1 ;
        List<CalculateResult> result = calculatorService.calculate(uid,eventID);

        List<Result> finalResult = calculatorService.finalResult(result, eventID);

        return JsonResult.createBySuccess(finalResult);
    }

}
