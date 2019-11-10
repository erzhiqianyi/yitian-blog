package com.erzhiqianyi.yitian.admin.system.model.enums;

public enum  SystemConfigEnum {
    SYSTEM_INFO("SYSTEM_INFO","系统基本信息"),
    SYSTEM_NAME("SYSTEM_NAME","网站名字"),
    DOMAIN("DOMAIN","域名"),
    INSTALL_TIME("INSTALL_TIME","安装时间"),

    ;
    private String code;
    private String remark;

    SystemConfigEnum(String code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public String getRemark() {
        return remark;
    }

    public boolean isCode(String code) {
        return getCode().equalsIgnoreCase(code);
    }
}
