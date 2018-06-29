package com.zz.bill.service.user;

import com.zz.bill.entity.account.UserInfo;

import java.util.List;

public interface IUserService {

    // 添加
    UserInfo addUser(UserInfo userInfo) throws Exception;

    // 查询
    Boolean checkAccountNameExist(String accountName);
    Boolean checkUserExist(Integer UID);
    List<UserInfo> findByNickName (String nickName);


    // 更新
    UserInfo UpdateUser(UserInfo userInfo);

    // 信息完整性查询
    UserInfo checkValidity(UserInfo userInfo);
}
