package com.zz.bill.repo;

import com.zz.bill.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, Integer> {
    List<Event> findBycreatorUid(Integer uid);

}
