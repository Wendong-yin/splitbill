package com.zz.bill.util;

import lombok.Getter;

@Getter
public enum EventStatus {
    ACTIVE,
    DEAD,
    ;

    private String status;

    EventStatus() {
    }

    EventStatus(String status) {
        this.status = status;
    }


}
