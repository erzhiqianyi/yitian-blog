package com.erzhiqianyi.yitian.admin.system.dao.mapper;

import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemLogEntity;
import com.erzhiqianyi.yitian.admin.system.model.po.SystemLogQuery;
import org.apache.ibatis.annotations.*;

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


    @Select({" select ",
            " id, type, status, remark, create_at, create_by ",
            " from ",
            " system_log "
    }
    )
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "type", property = "type"),
            @Result(column = "remark", property = "remark"),
            @Result(column = "create_at", property = "createAt"),
            @Result(column = "create_by", property = "createBy"),
    })
    List<SystemLogEntity> selectByPage(SystemLogQuery query);


    @Select({
            " select ",
            " count(*) ",
            " from ",
            " system_log "

    })
    Integer count(SystemLogQuery query);
}
