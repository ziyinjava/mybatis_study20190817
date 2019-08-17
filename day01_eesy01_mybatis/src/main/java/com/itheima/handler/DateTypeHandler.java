package com.itheima.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author ziyin
 @create 2019-06-2019/6/29-16:20
 */
public class DateTypeHandler extends BaseTypeHandler<Date> {

    //java类型转换为数据库类型
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType)
            throws SQLException {
        preparedStatement.setLong(i,date.getTime());
    }

    //将数据库类型转换为java类型

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long time = resultSet.getLong(i);
        return new Date(time);
    }

    //将数据库类型转换为java类型

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long time = callableStatement.getLong(i);
        return new Date(time);
    }

    //将数据库类型转换为java类型
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        long time = resultSet.getLong(s);
        return new Date(time);
    }
}
