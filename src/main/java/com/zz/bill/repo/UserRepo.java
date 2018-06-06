package com.zz.bill.repo;


import com.zz.bill.model.account.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {
    List<UserInfo> findByAccount(String account);
    List<UserInfo> findByNickName(String nickName);
}
