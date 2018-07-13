package com.zz.bill.repo;

import com.zz.bill.entity.Spend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpendRepo extends JpaRepository<Spend,Integer> {
    List<Spend> findByeventId(Integer eventId);
}
