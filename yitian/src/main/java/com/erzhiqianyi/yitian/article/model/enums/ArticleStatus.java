package com.erzhiqianyi.yitian.article.model.enums;

import lombok.Getter;

@Getter
public enum ArticleStatus {
    PUBLISH("PUBLISH","已发表"),
    DRAFT("DRAFT","草稿"),
    RECYCLE("RECYCLE","已回收");

    private String code;
    private String remark;

    ArticleStatus(String code, String remark) {
        this.code = code;
        this.remark = remark;
    }
}
