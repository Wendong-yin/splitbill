package com.zz.bill.repo;

import com.zz.bill.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepo extends JpaRepository<Result, Integer> {
    List<Result> findByEventID(Integer eventID);
}
