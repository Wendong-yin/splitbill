package com.zz.bill.repo;

import com.zz.bill.entity.EventUsersRel;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import java.util.List;

public interface EventUserRelRepo extends JpaRepository<EventUsersRel, Integer> {
    List<EventUsersRel> findByEventID(Integer eventId);


}
