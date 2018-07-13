package com.zz.bill.service;

import com.zz.bill.entity.User;

import java.util.List;

public interface IUserService {

    // 添加
    User addUser(User user) throws Exception;

    // 查询
    Boolean checkAccountNameExist(String accountName);
    Boolean checkUserExist(Integer UID);
    List<User> findByNickName (String nickName);


    // 更新
    User UpdateUser(User user);

    // 信息完整性查询
    User checkValidity(User user);
}
