package com.zz.bill.controller;

import com.zz.bill.CommonCode;
import com.zz.bill.model.JsonResult;
import com.zz.bill.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account/{version}")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/register/check")
    public JsonResult checkAccountExist(String accountName) {
        Boolean exist = accountService.checkExist(accountName);
        return JsonResult.builder().code(CommonCode.SUCC).msg("成功").data(exist).build();
    }

}
