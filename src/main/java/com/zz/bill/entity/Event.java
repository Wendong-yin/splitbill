package com.zz.bill.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zz.bill.util.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Event {

    @Id
    @GeneratedValue
    private Integer id;

    private String eventName;

    private EventStatus status = EventStatus.ACTIVE;

    private  Integer creatorUid;

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

}
