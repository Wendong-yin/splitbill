package com.zz.bill.controller;

import com.zz.bill.CommonCode;
import com.zz.bill.model.JsonResult;
import com.zz.bill.model.account.UserInfo;
import com.zz.bill.service.account.IAccountService;
import com.zz.bill.service.login.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/account/{version}")
public class AccountController {

    @Autowired
    private ILogin login;


//    @RequestMapping("/register/check")
//    public JsonResult checkAccountExist(String accountName) {
//        Boolean exist = accountService.checkExist(accountName);
//        return JsonResult.builder().code(CommonCode.SUCC).msg("成功").data(exist).build();
//    }

    @PostMapping(value = "/register")
    public JsonResult register(UserInfo userInfo,
                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return JsonResult.builder()
                    .msg(bindingResult.getAllErrors().get(0).getDefaultMessage())
                    .code(CommonCode.ACCOUNT_NOT_EXIST)
                    .build();
        }
        return login.register(userInfo);

    }

    @PostMapping(value = "/hello")
    public String hello(){
        return "hellow Spring";
    }



}
