package com.bluepha.common.handler;

import com.bluepha.common.utils.JsonUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * *****************************************************************************
 *
 *               Copyright(c) 2021 by 北京蓝晶微生物科技有限公司.
 *
 *                       All rights reserved.
 *
 *******************************************************************************
 *     File Name         :   JsonTypeHandler.java
 *
 *     Description       :   自定义JsonTypeHandler处理PostgreSQL的JSON数据类型
 * -----------------------------------------------------------------------------
 *     No.        Date              Revised by           Description
 *     0       2021-07-27             WuJi	               Created
 ********************************************************************************
 */

@MappedTypes({Object.class})
public class JsonTypeHandler extends BaseTypeHandler<Object> {

    /** 引入PGSQL提供的工具类PGobject */
    private static final PGobject jsonObject = new PGobject();

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        jsonObject.setType("json");
        jsonObject.setValue(JsonUtils.toJson(o));
        preparedStatement.setObject(i, jsonObject);
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getString(s);
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString(i);
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i);
    }
}