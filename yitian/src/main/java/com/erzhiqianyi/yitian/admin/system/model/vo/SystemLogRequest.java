package com.erzhiqianyi.yitian.admin.system.model.vo;

import com.erzhiqianyi.yitian.admin.system.model.enums.LogStatus;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogType;
import com.erzhiqianyi.yitian.admin.system.model.po.SystemLogQuery;
import com.erzhiqianyi.yitian.common.model.vo.PaginationRequest;
import com.erzhiqianyi.yitian.common.mybatis.SortOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ApiModel
@ToString(callSuper = true)
public class SystemLogRequest extends PaginationRequest {

    @ApiModelProperty(value = "关键词")
    private String keyWord;

    @ApiModelProperty(value = "日志类型")
    private LogType logType;

    @ApiModelProperty(value = "状态")
    private List<LogStatus> status;

    public SystemLogQuery toQuery() {
        SystemLogQuery query = new SystemLogQuery();
        query.setPage(getPage());
        query.setSize(getSize());
        query.setKeyWord(keyWord);
        query.setLogType(logType);
//        query.setStatus(status);
        query.setSortOrder(SortOrder.get(getSortOrder()));
        if (null != query.getSortField()) {
            switch (query.getSortField()) {
                case "createAt":
                    query.setSortField("create_at");
                    break;
            }
        }else {
            query.setSortField("create_at");
        }
        return query;

    }
}
