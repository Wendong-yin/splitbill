package com.zz.bill.controller;

import com.zz.bill.entity.Spend;
import com.zz.bill.model.JsonResult;
import com.zz.bill.service.spend.ISpentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/spend")
public class SpendController {


    @Autowired
    ISpentService spentService;

    public JsonResult createSpend(@RequestBody Spend spend){
        return spentService.createSpend(spend);
    }
}
