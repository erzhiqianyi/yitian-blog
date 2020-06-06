package com.erzhiqianyi.yitian.article.model.vo;

import lombok.Getter;

@Getter
public enum  SwitchEnum {
    OPEN("OPEN","允许"),
    CLOSE("CLOSE","不允许");
    private String code;
    private String remark;

    SwitchEnum(String code, String remark) {
        this.code = code;
        this.remark = remark;
    }
}
