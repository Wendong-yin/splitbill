package com.zz.bill.service.account;

import com.zz.bill.model.JsonResult;
import com.zz.bill.model.account.UserInfo;

public interface IAccountService {
    Boolean checkExist(String accountName);
    UserInfo register(UserInfo userInfo);

}
