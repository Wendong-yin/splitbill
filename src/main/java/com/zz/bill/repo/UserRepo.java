package com.zz.bill.repo;


import com.zz.bill.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findByAccount(String account);
    List<User> findByNickName(String nickName);
}
