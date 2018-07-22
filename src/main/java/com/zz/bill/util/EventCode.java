package com.zz.bill.util;

import lombok.Getter;

@Getter
public enum EventCode {
    USEREXISTSINEVENT("E001","This user has already in the evnet, please try another user"),
    EVENTNOTEXIST("E002", "This event does not exist")
    ;

    private String code;
    private String msg;

    EventCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
