package com.erzhiqianyi.yitian.admin.system.dao.entity;

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


}
