package com.zz.bill.controller;

import com.zz.bill.entity.Spend;
import com.zz.bill.model.JsonResult;
import com.zz.bill.service.spend.ISpentBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/spend")
public class SpendController {


    @Autowired
    ISpentBaseService spentService;

    @PostMapping("/create")
    public JsonResult createSpend(@RequestBody Spend spend){
        return spentService.createSpend(spend);
    }

    @PostMapping("/get")
    public JsonResult getOneSpend(@RequestParam Integer spendID){
        return spentService.getOneSpend(spendID);
    }

    @PostMapping("/getAll")
    public JsonResult getAllSpend(@RequestParam Integer eventID){
        return spentService.getAllSpend(eventID);
    }
}
