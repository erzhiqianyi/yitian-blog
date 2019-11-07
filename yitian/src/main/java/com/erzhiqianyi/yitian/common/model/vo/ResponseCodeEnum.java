package com.erzhiqianyi.yitian.common.model.vo;

public enum ResponseCodeEnum {
    SUCCESS(0,"处理成功"),
    NO_DATA(20000,"没有数据"),
    BAD_REQUEST(400,"请求数据错误");
    private int code;
    private String msg;

    ResponseCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
