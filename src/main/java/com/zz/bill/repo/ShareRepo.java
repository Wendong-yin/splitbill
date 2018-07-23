package com.zz.bill.repo;

import com.zz.bill.entity.Share;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShareRepo extends JpaRepository<Share,Integer> {
    List<Share> findBySpendID(Integer spendID);

}
