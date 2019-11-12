package com.erzhiqianyi.yitian.admin.system.dao.mapper;

import com.erzhiqianyi.yitian.admin.system.dao.entity.AdministratorEntity;
import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface AdministratorMapper {

    @Insert({
            " insert into ",
            "  administrator ",
            " ( ",
            " email, nickname, username, password , uuid ,  ",
            " create_at, update_at, create_by, update_by",
            ") ",
            " values ",
            " ( ",
            " #{email} , ", "#{nickname} , ", "#{username} , #{password} , #{uuid} , ",
            " #{createAt} , ", "#{updateAt} , ", "#{createBy} , ", "#{updateBy}",
            " ) "
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    void insert(AdministratorEntity administrator);

    @Select({
            " select ",
            " id, email, nickname, username, password ,uuid ",
            " from administrator ",
            " where",
            " email = #{email} "
    })
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "email", property = "email"),
            @Result(column = "nickname", property = "nickname"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "uuid", property = "uuid"),
    })
    Optional<AdministratorEntity> selectByEmail(String email);
}
