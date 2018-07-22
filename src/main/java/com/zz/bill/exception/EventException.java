package com.zz.bill.exception;

import com.zz.bill.util.EventCode;

public class EventException extends RuntimeException {
    private String code;

    public EventException(EventCode eventCode) {
        super(eventCode.getMsg());
        this.code = eventCode.getCode();
    }

    public String getCode() {
        return code;
    }

}
