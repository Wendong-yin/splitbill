package com.zz.bill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class EventUsersRel {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer eventID;
    private Integer uid;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    @PrePersist
    public void prePresist(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        createdAt = timestamp;
        updatedAt = timestamp;
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public EventUsersRel(Integer eventID, Integer uid) {
        this.eventID = eventID;
        this.uid = uid;
    }
}
