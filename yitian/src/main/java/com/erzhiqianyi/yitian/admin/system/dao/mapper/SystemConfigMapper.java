package com.erzhiqianyi.yitian.admin.system.dao.mapper;

import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemConfigEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SystemConfigMapper {

    @Insert({
            " insert into ",
            " system_config ",
            " ( ",
            "name, code, parent ,value, ",
            "create_at, update_at, create_by, update_by",
            ") ",
            " values ",
            " ( ",
            " #{name} , ", "#{code} , ", "#{parent} , ", "#{value} , ",
            " #{createAt} , ", "#{updateAt} , ", "#{createBy} , ", "#{updateBy}",
            " ) "
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    void insert(SystemConfigEntity config);

    @Insert({
            " <script> " ,
            " insert into ",
            " system_config ",
            " ( ",
            "name, code, parent ,value, ",
            "create_at, update_at, create_by, update_by",
            ") ",
            " values ",
            "<foreach collection='list' index='index' item='item' separator=','> ",
            " ( ",
            " #{item.name} , ", "#{item.code} , ", "#{item.parent} , ", "#{item.value} , ",
            " #{item.createAt} , ", "#{item.updateAt} , ", "#{item.createBy} , ", "#{item.updateBy}",
            " ) ",
            " </foreach> ",
            " </script> "
    })
    void batchInsert(List<SystemConfigEntity> items);

    @Select({
            " select ",
            " id, name, code, parent , value ",
            " from system_config ",
            " where",
            " code = #{code} "
    })
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "name", property = "name"),
            @Result(column = "code", property = "code"),
            @Result(column = "parent", property = "parent"),
            @Result(column = "value", property = "value"),
    })
    Optional<SystemConfigEntity> selectByCode(String code);


    @Select({
            " select ",
            " id, name, code, parent , value ",
            " from system_config ",
            " where",
            " parent = #{parent} "
    })
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "name", property = "name"),
            @Result(column = "code", property = "code"),
            @Result(column = "parent", property = "parent"),
            @Result(column = "value", property = "value"),
    })
    List<SystemConfigEntity> selectByParent(String parent);



}
