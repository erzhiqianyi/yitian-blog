package com.erzhiqianyi.yitian.article.model.po;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;

@ApiModel("推荐配置")
@Data
public class AccessPermission {

    private Group group;

    @Getter
    public enum Group {
        PUBLIC("PUBLIC", "公开"),
        PRIVATE("SELF", "仅自己"),
        BLACK("BLACKLIST", "黑名单"),
        WHITE("WHITELIST", "白名单");

        private String code;
        private String remark;

        Group(String code, String remark) {
            this.code = code;
            this.remark = remark;
        }
    }
}
