package com.erzhiqianyi.yitian.admin.system.model.po;

import com.erzhiqianyi.yitian.admin.system.model.enums.LogStatus;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogType;
import com.erzhiqianyi.yitian.common.mybatis.PaginationQuery;
import lombok.Data;

import java.util.List;

@Data
public class SystemLogQuery extends PaginationQuery {

    private String keyWord;

    private List<LogType> logType;

    private List<LogStatus> status;


    public boolean empty() {
        return null != keyWord
                || (null != logType && !logType.isEmpty())
                || (null != status && !status.isEmpty());
    }


    public String where() {
        if (null != keyWord){
            return " key_word = #{keyWord}";
        }
        return null;
    }
}
