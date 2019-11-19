package com.erzhiqianyi.yitian.admin.system.dao.mapper;

import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemLogEntity;
import com.erzhiqianyi.yitian.admin.system.model.po.SystemLogQuery;
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


    @Select({
            " select ",
            " count(*) ",
            " from ",
            " system_log "

    })
    Integer count(SystemLogQuery query);

    class SystemLogProvider {
        public String selectByPage(SystemLogQuery query) {
            SQL sql = new SQL();
            sql.SELECT("id");
            sql.SELECT("type");
            sql.SELECT("status");
            sql.SELECT("remark");
            sql.SELECT("create_at");
            sql.SELECT("create_by");
            sql.FROM("system_log ");
            if (query.empty()){
                sql.WHERE(query.where());
            }
            return sql.toString();
        }
    }
}
