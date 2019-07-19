package com.erzhiqianyi.blog.dao.mapper.user;

import com.erzhiqianyi.blog.dao.entity.user.UserEntity;
import com.erzhiqianyi.blog.dao.entity.user.UserEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @SelectProvider(type=UserMapperProvider.class, method="countByExample")
    long countByExample(UserEntityExample example);

    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (username, email, ",
        "password, create_at, ",
        "update_at, create_by, ",
        "update_by, status)",
        "values (#{username,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{createAt,jdbcType=BIGINT}, ",
        "#{updateAt,jdbcType=BIGINT}, #{createBy,jdbcType=INTEGER}, ",
        "#{updateBy,jdbcType=INTEGER}, #{status,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(UserEntity record);

    @InsertProvider(type=UserMapperProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(UserEntity record);

    @SelectProvider(type=UserMapperProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.BIGINT),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.BIGINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<UserEntity> selectByExample(UserEntityExample example);

    @Select({
        "select",
        "id, username, email, password, create_at, update_at, create_by, update_by, status",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.BIGINT),
        @Result(column="update_at", property="updateAt", jdbcType=JdbcType.BIGINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="update_by", property="updateBy", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    UserEntity selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserMapperProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    @UpdateProvider(type=UserMapperProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    @UpdateProvider(type=UserMapperProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserEntity record);

    @Update({
        "update user",
        "set username = #{username,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "create_at = #{createAt,jdbcType=BIGINT},",
          "update_at = #{updateAt,jdbcType=BIGINT},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "update_by = #{updateBy,jdbcType=INTEGER},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserEntity record);
}