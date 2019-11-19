package com.erzhiqianyi.yitian.admin.system.dao.mapper;

import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemLogEntity;
import com.erzhiqianyi.yitian.admin.system.dao.query.SystemLogQuery;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface SystemLogMapper {

    @Insert({
            " insert into ",
            " system_log ",
            " ( ",
            " type, remark, status, key_word ,create_at, create_by ",
            " ) ",
            " values",
            " ( ",
            " #{type}, #{remark}, #{status}, #{keyWord} , #{createAt}, #{createBy}",
            ")"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    void insert(SystemLogEntity log);


    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "type", property = "type"),
            @Result(column = "remark", property = "remark"),
            @Result(column = "create_at", property = "createAt"),
            @Result(column = "create_by", property = "createBy"),
    })
    @SelectProvider(type = SystemLogProvider.class, method = "selectByPage")
    List<SystemLogEntity> selectByPage(SystemLogQuery query);


    @SelectProvider(type = SystemLogProvider.class, method = "count")
    Integer count(SystemLogQuery query);

    @Log4j2
    class SystemLogProvider {
        public String selectByPage(SystemLogQuery query) {
            SQL sql = new SQL();
            sql.SELECT("id")
                    .SELECT("type")
                    .SELECT("status")
                    .SELECT("remark")
                    .SELECT("create_at")
                    .SELECT("create_by")
                    .FROM("system_log");
            if (!query.isEmpty()) {
                sql.WHERE(query.where());
            }
            return sql.toString();
        }

        public String count(SystemLogQuery query) {
            SQL sql = new SQL();
            sql.SELECT("count(*)").FROM("system_log");
            if (!query.isEmpty()) {
                sql.WHERE(query.where());
            }
            return sql.toString();
        }
    }
}
