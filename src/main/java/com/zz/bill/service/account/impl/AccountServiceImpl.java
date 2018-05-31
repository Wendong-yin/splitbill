package com.zz.bill.service.account.impl;

import com.zz.bill.entity.account.User;
import com.zz.bill.model.JsonResult;
import com.zz.bill.model.account.UserInfo;
import com.zz.bill.repo.UserRepo;
import com.zz.bill.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Boolean checkExist(String accountName) {
        return Boolean.FALSE;
    }

    @Override
    // 这里返回 User，
    public UserInfo register(UserInfo userInfo) {
        return userRepo.save(userInfo);
    }

}
