package com.zz.bill.exception;

import com.zz.bill.util.CommonCode;

public class UserException extends RuntimeException {
    private String code;

    public UserException(CommonCode commonCode) {
        super(commonCode.getMessage());
        this.code = commonCode.getCode();
    }

    public String getCode() {
        return code;
    }
}
