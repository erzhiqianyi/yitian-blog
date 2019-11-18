package com.erzhiqianyi.yitian.common.mybatis;

public enum SortOrder {
    DESC("descend"),
    ASC("ascend");
    private String code;

    SortOrder(String code) {
        this.code = code;
    }

    public static SortOrder get(String sortOrder) {
        if (null == sortOrder ){
            return DESC;
        }
        switch (sortOrder){
            case  "descend":
                return DESC;
            case "ascend":
                return ASC;
        }
        return DESC;
    }

    public String getCode() {
        return code;
    }
}
