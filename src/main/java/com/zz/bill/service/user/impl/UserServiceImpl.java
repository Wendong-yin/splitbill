package com.zz.bill.service.user.impl;

import com.zz.bill.CommonCode;
import com.zz.bill.exception.UserException;
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
    public UserInfo checkValidity(UserInfo userInfo) {
        if (userInfo.getAccount() == null || userInfo.getPassword() == null){
            throw new UserException(CommonCode.PARAM_ERR);
        }
        return userInfo;
    }

    @Override
    public Boolean checkUserExist(Integer UID) {
        UserInfo userInfo = userRepo.findOne(UID);
        if (userInfo == null){
            return false; // 用户不存在
        }else{
            return true;
        }
    }

    @Override
    public Boolean checkAccountNameExist(String accountName) {
        List<UserInfo> users = userRepo.findByAccount(accountName);
        if (users.size() > 0){
            return true; // 用户存在
        }else{
            return false; // 用户不存在
        }
    }

    @Override
    public UserInfo addUser(UserInfo userInfo) throws Exception {
        UserInfo user = checkValidity(userInfo);
        // ❤️ 为什么会有大黄线？？
        if (checkAccountNameExist(user.getAccount()) == true){
            throw new UserException(CommonCode.ACCOUNT_ALREADY_EXIST);
        }
        return userRepo.save(user);
    }


    @Override
    public List<UserInfo> findByNickName(String nickName) {
        return userRepo.findByNickName(nickName);
    }

    @Override
    public UserInfo UpdateUser(UserInfo userInfo) {
        return null;
    }


}
