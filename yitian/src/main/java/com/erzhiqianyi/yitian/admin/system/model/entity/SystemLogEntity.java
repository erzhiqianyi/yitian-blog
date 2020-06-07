package com.erzhiqianyi.yitian.admin.system.model.entity;

import com.erzhiqianyi.yitian.admin.system.model.enums.LogStatus;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SystemLogEntity {
    private Long id;
    private LogType type;
    private LogStatus status;
    private String keyWord;
    private String remark;
    private Long createAt;
    private Long createBy;
}
