package com.erzhiqianyi.yitian.admin.system.model.dto;

import com.erzhiqianyi.yitian.admin.system.model.entity.SystemConfigEntity;
import com.erzhiqianyi.yitian.admin.system.model.enums.SystemConfigEnum;
import lombok.Data;

@Data
public class SystemConfigDto {

    private Long id;
    private String name;
    private String code;
    private String parent;
    private String value;
    private Long createAt;
    private Long updateAt;
    private Long createBy;
    private Long updateBy;

    public SystemConfigDto(SystemConfigEnum config, String value, SystemConfigEnum parent,Long createBy) {
        this.name = config.getRemark();
        this.code = config.getCode();
        this.parent = parent.getCode();
        this.value = value;
        this.createAt = System.currentTimeMillis();
        this.updateAt = this.createAt;
        this.createBy = createBy;
        this.updateBy = createBy;

    }

    public SystemConfigEntity toAddEntity() {
        SystemConfigEntity config = new SystemConfigEntity();
        config.setName(name);
        config.setCode(code);
        config.setParent(parent);
        config.setValue(value);
        config.setCreateAt(createAt);
        config.setUpdateAt(updateAt);
        config.setCreateBy(createBy);
        config.setUpdateBy(updateBy);
        return config;
    }
}
