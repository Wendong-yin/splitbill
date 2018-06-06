package com.zz.bill.service.user;

import com.zz.bill.model.account.UserInfo;

import java.util.List;

public interface IUserService {

    // 添加
    UserInfo addUser(UserInfo userInfo);

    // 查询
    Boolean checkAccountNameExist(String accountName);
    Boolean checkUserExist(Integer UID);
    List<UserInfo> findByNickName (String nickName);

    // 更新
    UserInfo UpdateUser(UserInfo userInfo);
}