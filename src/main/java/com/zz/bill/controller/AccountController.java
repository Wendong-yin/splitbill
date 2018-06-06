package com.zz.bill.controller;

import com.zz.bill.CommonCode;
import com.zz.bill.model.JsonResult;
import com.zz.bill.model.account.UserInfo;
import com.zz.bill.service.login.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account/{version}")
public class AccountController {

    @Autowired
    private ILogin login;

    // ❤️ 我觉得 bingdingresult 检查功能太简单了，比如复杂的密码检查功能，并且放在 congtroller 代码带多了
    @PostMapping(value = "/register")
    public JsonResult register(@RequestBody UserInfo userInfo,
                               BindingResult bindingResult) throws Exception{
//        if(bindingResult.hasErrors()){
//            return JsonResult.builder()
//                    .msg(bindingResult.getAllErrors().get(0).getDefaultMessage())
//                    .code(CommonCode.ACCOUNT_NOT_EXIST.getCode())
//                    .build();
//        }
        return login.register(userInfo);

    }

    @PostMapping(value = "/login")
    public JsonResult login(@RequestBody UserInfo userInfo)throws Exception{
        return login.login(userInfo);
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "hellow Spring";
    }
}
