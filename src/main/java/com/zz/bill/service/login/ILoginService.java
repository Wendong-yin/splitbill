package com.zz.bill.service.login;

import com.zz.bill.model.JsonResult;
import com.zz.bill.model.account.UserInfo;
import com.zz.bill.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ILoginService implements ILogin {

    @Autowired
    private IUserService accountService;


    @Override
    public JsonResult register(UserInfo userInfo) {
        UserInfo user = accountService.addUser(userInfo);
        return JsonResult.builder()
                .data(user)
                .build();
    }
}
