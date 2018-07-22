package com.zz.bill.util;

public enum CommonCode {
    SUCC("S000","成功"),

    SYS_ERR("E001","系统错误"),
    AUTH_FORBIDDEN("E002","权限不足"),
    PARAM_ERR("E003","参数不全"),

    ACCOUNT_NOT_EXIST("U001","账户不存在"),
    WRONG_PWD("U002","密码错误"),
    ACCOUNT_ALREADY_EXIST("U003","账户已经存在"),
    INVALID_PWD("U004","密码不符合要求")
    ;

    private String code;
    private String message;

    CommonCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

        /*
    成功|S000
    |
    系统错误|E001
    权限不足|E002
    参数不全|E010
    |
    账户不存在      |U001
    密码错误        |U002
    账户已经存在    |U003
    密码不符合要求  |U004
     */
//    public static final String SUCC="S000";
//
//    public static final String SYS_ERR="E001";
//    public static final String AUTH_FORBIDDEN="E002";
//    public static final String PARAM_ERR="E003";
//
//    public static final String ACCOUNT_NOT_EXIST="U001";
//    public static final String WRONG_PWD="U002";
//    public static final String ACCOUNT_ALREADY_EXIST="U003";
//    public static final String INVALID_PWD="U004";
}
