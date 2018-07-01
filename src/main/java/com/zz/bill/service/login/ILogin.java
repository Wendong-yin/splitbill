package com.zz.bill.service.login;

import com.zz.bill.model.JsonResult;
import com.zz.bill.entity.account.User;

public interface ILogin {
    JsonResult register (User user) throws Exception;
    JsonResult login (User user) throws Exception;

}
