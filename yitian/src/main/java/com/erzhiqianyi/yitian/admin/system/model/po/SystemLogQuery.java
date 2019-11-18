package com.erzhiqianyi.yitian.admin.system.model.po;

import com.erzhiqianyi.yitian.admin.system.model.enums.LogStatus;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogType;
import com.erzhiqianyi.yitian.common.mybatis.PaginationQuery;
import lombok.Data;

@Data
public class SystemLogQuery extends PaginationQuery {

    private String keyWord;

    private LogType logType;

    private LogStatus status;



}
