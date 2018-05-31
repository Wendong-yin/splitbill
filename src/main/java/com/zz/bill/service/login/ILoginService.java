package com.zz.bill.service.login;

import com.zz.bill.entity.account.User;
import com.zz.bill.model.JsonResult;
import com.zz.bill.model.account.UserInfo;
import com.zz.bill.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ILoginService implements ILogin {

    @Autowired
    private IAccountService accountService;


    @Override
    public JsonResult register(UserInfo userInfo) {
        UserInfo user = accountService.register(userInfo);
        return JsonResult.builder()
                .data(user)
                .build();
    }
}
