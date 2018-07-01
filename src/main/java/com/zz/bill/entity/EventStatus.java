package com.zz.bill.entity;

public enum EventStatus {
    OPEN(0,"成功"),
    CLOSE(1,"关闭"),
    ;

    private Integer code;
    private String status;

    EventStatus(Integer code, String status) {
        this.code = code;
        this.status = status;
    }
}
