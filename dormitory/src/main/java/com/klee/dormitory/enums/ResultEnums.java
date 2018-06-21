package com.klee.dormitory.enums;

public class ResultEnums {
    private Integer code;
    private String msg;

    public ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
