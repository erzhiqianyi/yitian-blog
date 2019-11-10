package com.erzhiqianyi.yitian.admin.system.dao.entity;

import com.erzhiqianyi.yitian.admin.system.model.enums.SystemConfigEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SystemConfigEntity {
    private Long id;
    private String name;
    private String code;
    private String parent;
    private String value;
    private Long createAt;
    private Long updateAt;
    private Long createBy;
    private Long updateBy;

    public SystemConfigEntity(SystemConfigEnum config, String value, SystemConfigEnum parent) {
        this.name = config.getRemark();
        this.code = config.getCode();
        this.parent = parent.getCode();
        this.value = value;
        this.createAt = System.currentTimeMillis();
        this.updateAt = this.createAt;
        this.createBy = 0l;
        this.updateBy = 0l;
    }
}
