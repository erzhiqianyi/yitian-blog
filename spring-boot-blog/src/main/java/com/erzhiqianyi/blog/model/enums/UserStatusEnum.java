package com.erzhiqianyi.blog.model.enums;

public enum  UserStatusEnum {
    VALID("VALID","有效"),
    DELETED("DELETED","删除");


    UserStatusEnum(String status, String remark) {
        this.status = status;
        this.remark = remark;
    }

    private String status;
    private String remark;

    public String getStatus() {
        return status;
    }

    public String getRemark() {
        return remark;
    }
}
