package com.erzhiqianyi.yitian.admin.system.dao.query;

import com.erzhiqianyi.yitian.admin.system.model.enums.LogStatus;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogType;
import com.erzhiqianyi.yitian.common.mybatis.PaginationQuery;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class SystemLogQuery extends PaginationQuery {


    private String keyWord;

    private List<LogType> logType;

    private List<LogStatus> status;


    public boolean isEmpty() {
        return (null == keyWord || "".equalsIgnoreCase(keyWord))
                && (null == logType || logType.isEmpty())
                && (null == status || status.isEmpty());
    }


    public String where() {
        List<String> where = new ArrayList<>();
        if (null != keyWord && !"".equalsIgnoreCase(keyWord)) {
            where.add(" key_word = #{keyWord}");
        }

        if (null != logType && !logType.isEmpty()) {
            StringBuilder typeBuilder = new StringBuilder();
            typeBuilder.append(" type in ");
            typeBuilder.append(" ( ");
            boolean comma = false;
            for (int k = 0; k < logType.size(); k++) {
                if (comma) {
                    typeBuilder.append(" , ");
                } else {
                    comma = true;
                }
                typeBuilder.append("#{logType[" + k + "]}");
            }
            typeBuilder.append(" ) ");
            where.add(typeBuilder.toString());
        }

        if (null != status && !status.isEmpty()) {
            StringBuilder statusBuilder = new StringBuilder();
            statusBuilder.append(" status in ");
            statusBuilder.append(" ( ");
            boolean comma = false;
            for (int k = 0; k < status.size(); k++) {
                if (comma) {
                    statusBuilder.append(" , ");
                } else {
                    comma = true;
                }
                statusBuilder.append("#{status[" + k + "]}");
            }
            statusBuilder.append(" ) ");
            where.add(statusBuilder.toString());
        }

        boolean first = true;
        StringBuilder builder = new StringBuilder();
        for (String query : where) {
            if (first) {
                builder.append(query);
                first = false;
            } else {
                builder.append(" and ").append(query);
            }
        }
        return builder.toString();
    }
}
