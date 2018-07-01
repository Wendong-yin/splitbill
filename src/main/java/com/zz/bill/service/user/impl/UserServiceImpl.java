package com.zz.bill.service.user.impl;

import com.zz.bill.CommonCode;
import com.zz.bill.exception.UserException;
import com.zz.bill.entity.account.User;
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
    public User checkValidity(User user) {
        if (user.getAccount() == null || user.getPassword() == null){
            throw new UserException(CommonCode.PARAM_ERR);
        }
        return user;
    }

    @Override
    public Boolean checkUserExist(Integer UID) {
        User user = userRepo.findOne(UID);
        if (user == null){
            return false; // 用户不存在
        }else{
            return true;
        }
    }

    @Override
    public Boolean checkAccountNameExist(String accountName) {
        List<User> users = userRepo.findByAccount(accountName);
        if (users.size() > 0){
            return true; // 用户存在
        }else{
            return false; // 用户不存在
        }
    }

    @Override
    public User addUser(User userInfo) throws Exception {
        User user = checkValidity(userInfo);
        // ❤️ 为什么会有大黄线？？
        if (checkAccountNameExist(user.getAccount()) == true){
            throw new UserException(CommonCode.ACCOUNT_ALREADY_EXIST);
        }
        return userRepo.save(user);
    }


    @Override
    public List<User> findByNickName(String nickName) {
        return userRepo.findByNickName(nickName);
    }

    @Override
    public User UpdateUser(User user) {
        return null;
    }


}
