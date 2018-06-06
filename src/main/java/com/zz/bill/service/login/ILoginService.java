package com.zz.bill.service.login;

import com.zz.bill.CommonCode;
import com.zz.bill.model.JsonResult;
import com.zz.bill.model.account.UserInfo;
import com.zz.bill.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ILoginService implements ILogin {

    // ❤️ 这个为什么有黄线
    @Autowired
    private IUserService accountService;

    @Override
    public JsonResult register(UserInfo userInfo) throws Exception {
        UserInfo user = accountService.addUser(userInfo);
        return JsonResult.builder()
                .code(CommonCode.SUCC.getCode())
                .msg(CommonCode.SUCC.getMessage())
                .data(user)
                .build();
    }
}
