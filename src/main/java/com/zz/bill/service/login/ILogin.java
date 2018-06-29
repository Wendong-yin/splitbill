package com.zz.bill.service.login;

import com.zz.bill.model.JsonResult;
import com.zz.bill.entity.account.UserInfo;

public interface ILogin {
    JsonResult register (UserInfo userInfo) throws Exception;
    JsonResult login (UserInfo userInfo) throws Exception;

}
