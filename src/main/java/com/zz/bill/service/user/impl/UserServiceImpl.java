package com.zz.bill.service.user.impl;

import com.zz.bill.model.account.UserInfo;
import com.zz.bill.repo.UserRepo;
import com.zz.bill.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserRepo userRepo;

    @Override
    public Boolean checkUserExist(Integer UID) {
        UserInfo userInfo = userRepo.findOne(UID);
        if (userInfo == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public UserInfo addUser(UserInfo userInfo) {
        return null;
    }

    @Override
    public Boolean checkAccountNameExist(String accountName) {
        return null;
    }



    @Override
    public List<UserInfo> findByNickName(String nickName) {
        return null;
    }

    @Override
    public UserInfo UpdateUser(UserInfo userInfo) {
        return null;
    }
}
