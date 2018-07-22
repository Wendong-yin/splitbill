package com.zz.bill.controller;

import com.zz.bill.model.JsonResult;
import com.zz.bill.service.share.IShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/share")
public class ShareController {

    @Autowired
    IShareService shareService;

    @PostMapping(value = "/add")
    JsonResult addShare(@RequestParam List<Integer> users, @RequestParam Integer eventID){
        return shareService.addShare(users, eventID);
    }

}
