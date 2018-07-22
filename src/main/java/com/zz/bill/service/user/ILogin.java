package com.zz.bill.service.user;

import com.zz.bill.model.JsonResult;
import com.zz.bill.entity.User;

public interface ILogin {
    JsonResult register (User user) throws Exception;
    JsonResult login (User user) throws Exception;

}
