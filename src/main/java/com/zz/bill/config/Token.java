package com.zz.bill.config;

public enum Token {
    WENDONG("wendong","88888888"),
    Mary("mary","7777777"),
    Tom("Tom","happy"),
    ;

    private String name;
    private String token;

    Token(String name, String token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
