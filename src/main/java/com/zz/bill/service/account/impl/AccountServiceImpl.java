package com.zz.bill.service.account.impl;

import com.zz.bill.service.account.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Override
    public Boolean checkExist(String accountName) {
        return Boolean.FALSE;
    }
}
