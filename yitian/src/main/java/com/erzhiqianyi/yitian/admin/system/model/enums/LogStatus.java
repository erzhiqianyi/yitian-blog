package com.erzhiqianyi.yitian.admin.system.model.enums;

import com.erzhiqianyi.yitian.common.model.enums.BaseEnum;

public enum LogStatus implements BaseEnum {
    SUCCESS("SUCCESS", "成功"),
    FAIL("FAIL", "失败");
    private String code;
    private String remark;

    LogStatus(String code, String remark) {
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
