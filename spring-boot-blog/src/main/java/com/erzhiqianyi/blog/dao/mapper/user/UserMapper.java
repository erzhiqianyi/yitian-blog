package com.erzhiqianyi.blog.dao.mapper.user;


import com.erzhiqianyi.blog.dao.entity.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper {

    @Select({
            " select ",
            " id, username, email, password ",
            " from user ",
            " where",
            " id = #{id}"
    })
    Optional<UserEntity> selectById(@Param("id") Integer id);
}
