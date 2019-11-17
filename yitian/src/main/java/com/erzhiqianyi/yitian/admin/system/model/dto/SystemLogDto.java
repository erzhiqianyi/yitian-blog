package com.erzhiqianyi.yitian.admin.system.model.dto;

import com.erzhiqianyi.yitian.admin.administrator.model.dto.AdministratorDto;
import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemConfigEntity;
import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemLogEntity;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogStatus;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogType;
import com.erzhiqianyi.yitian.security.model.bo.AuthResponse;
import com.erzhiqianyi.yitian.security.model.dto.PasswordAuthDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SystemLogDto {
    private Long id;
    private LogType type;
    private LogStatus status;
    private String keyWord;
    private String remark;
    private Long createAt;
    private Long createBy;

    public SystemLogDto(LogType type, LogStatus status, String remark) {
        this.type = type;
        this.status = status;
        this.remark = remark;
        this.createAt = System.currentTimeMillis();
        this.createBy = 0l;
        this.keyWord = type.code();
    }

    public static SystemLogDto addAdministratorLog(AdministratorDto item, LogStatus status) {
        SystemLogDto dto = new SystemLogDto();
        dto.setType(LogType.ADD_ADMINISTRATOR);
        dto.setStatus(status);
        dto.setKeyWord(item.getEmail());
        dto.setRemark(item.getEmail());
        dto.setCreateAt(System.currentTimeMillis());
        dto.setCreateBy(item.getId());
        dto.setCreateAt(item.getCreateAt());
        return dto;
    }

    public static SystemLogDto addSystemConfigLog(SystemConfigDto item, LogStatus status) {
        SystemLogDto dto = new SystemLogDto();
        dto.setType(LogType.ADD_SYSTEM_CONFIG);
        dto.setStatus(status);
        dto.setKeyWord(item.getCode());
        dto.setRemark(item.getName() + " : " + item.getValue());
        dto.setCreateAt(item.getCreateAt());
        dto.setCreateBy(item.getCreateBy());
        return dto;
    }

    public static SystemLogDto addLoginLog(PasswordAuthDto authInfo, AuthResponse authResponse) {
        SystemLogDto dto = new SystemLogDto();
        dto.setType(LogType.LOGIN);
        if (null != authResponse.getToken()) {
            dto.setStatus(LogStatus.SUCCESS);
        } else {
            dto.setStatus(LogStatus.FAIL);
        }
        dto.setKeyWord(authInfo.getEmail());
        dto.setRemark(authInfo.getEmail());
        dto.setCreateAt(System.currentTimeMillis());
        dto.setCreateBy(0l);
        return dto;
    }


    public SystemLogEntity toAddEntity() {
        SystemLogEntity log = new SystemLogEntity();
        log.setType(type);
        log.setStatus(status);
        log.setKeyWord(keyWord);
        log.setCreateAt(createAt);
        log.setCreateBy(createBy);
        log.setRemark(remark);
        return log;
    }
}
