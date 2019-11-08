package com.erzhiqianyi.yitian.admin.system.dao.mapper;

import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemConfigEntity;
import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface SystemConfigMapper {

    @Insert({
            " insert into ",
            " system_config ",
            " ( ",
            "name, code, value, ",
            "create_at, update_at, create_by, update_by",
            ") ",
            " values ",
            " ( ",
            " #{name} , ", "#{code} , ", "#{value} , ",
            " #{createAt} , ", "#{updateAt} , ", "#{createBy} , ", "#{updateBy}",
            " ) "
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    Integer insert(SystemConfigEntity config);

    @Select({
            " select ",
            " id, name, code, value ",
            " from system_config",
            " where",
            " code = #{code} "
    })
    @Results({
            @Result(column="id", property="id",  id=true),
            @Result(column="name", property="name"),
            @Result(column="code", property="code" ),
            @Result(column="value", property="value"),
    })
    Optional<SystemConfigEntity> selectByCode(String code);
}
