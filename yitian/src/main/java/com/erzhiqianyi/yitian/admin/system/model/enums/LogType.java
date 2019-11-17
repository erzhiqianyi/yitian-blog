package com.erzhiqianyi.yitian.admin.system.model.enums;

import com.erzhiqianyi.yitian.common.model.enums.BaseEnum;

public enum LogType implements BaseEnum {
    SYSTEM_INITIALIZATION("SYSTEM_INITIALIZATION","系统初始化"),
    ADD_ADMINISTRATOR("ADD_ADMINISTRATOR","添加管理员"),
    ADD_SYSTEM_CONFIG("ADD_SYSTEM_CONFIG","添加系统配置"),
    LOGIN("LOGIN","登录"),
    POST_ARTICLE("POST_ARTICLE","新建文章"),
    EDIT_ARTICLE("EDIT_ARTICLE","修改文章")
    ;
    private String code;
    private String remark;

    LogType(String code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String remark() {
        return remark;
    }
}
