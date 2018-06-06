package com.zz.bill.service.login;

import com.zz.bill.model.JsonResult;
import com.zz.bill.model.account.UserInfo;
import sun.reflect.annotation.ExceptionProxy;

public interface ILogin {
    JsonResult register (UserInfo userInfo) throws Exception;
    JsonResult login (UserInfo userInfo) throws Exception;

}
