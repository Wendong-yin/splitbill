package com.zz.bill.repo;


import com.zz.bill.model.account.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {
}
