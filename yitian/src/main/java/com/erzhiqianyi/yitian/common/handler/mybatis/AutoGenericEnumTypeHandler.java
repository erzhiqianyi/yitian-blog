package com.erzhiqianyi.yitian.common.handler.mybatis;

import com.erzhiqianyi.yitian.common.model.enums.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.stream.Stream;

public class AutoGenericEnumTypeHandler<E extends BaseEnum> extends BaseTypeHandler<E> {
    private Class<E> enumType;
    private E[] enums;

    public AutoGenericEnumTypeHandler(Class<E> enumType) {
        if (null == enumType) {
            throw new IllegalArgumentException("type argument cant't be null ");
        }
        this.enumType = enumType;
        this.enums = enumType.getEnumConstants();
        if (null == this.enums) {
            throw new IllegalArgumentException(enumType.getName() + " does not represent an enum type");
        }
    }

    private E loadEnum(String code) {
        Optional<E> optional = Stream.of(enums).filter(item -> item.code().equalsIgnoreCase(code))
                .findFirst();
        if (optional.isPresent()){
            return optional.get();
        }else {
            return null;
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, e.code());
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        if (null == resultSet.getObject(s)) {
            return null;
        }
        String code = resultSet.getString(s);
        return loadEnum(code);
   }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        if (null == resultSet.getObject(i)){
            return null;
        }
        String code = resultSet.getString(i);
        return loadEnum(code);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        if (null == callableStatement.getObject(i)){
            return null;
        }
        String code = callableStatement.getString(i);
        return loadEnum(code);
    }
}
