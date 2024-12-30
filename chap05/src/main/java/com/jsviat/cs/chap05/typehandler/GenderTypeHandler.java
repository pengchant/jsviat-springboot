package com.jsviat.cs.chap05.typehandler;

import com.jsviat.cs.chap05.dic.GenderEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(GenderEnum.class)
public class GenderTypeHandler extends BaseTypeHandler<GenderEnum> {

    // 设置非空性别参数
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, GenderEnum gender, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, gender.getId());
    }

    // 通过列名读取性别
    @Override
    public GenderEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        var sex = resultSet.getInt(s);
        if (sex != 1 && sex != 2) {
            return null;
        }
        return GenderEnum.getGenderById(sex);
    }

    // 通过下标读取性别
    @Override
    public GenderEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        var sex = resultSet.getInt(i);
        if (sex != 1 && sex != 2) {
            return null;
        }
        return GenderEnum.getGenderById(sex);
    }

    // 通过存储过程读取性别
    @Override
    public GenderEnum getNullableResult(CallableStatement cs, int i) throws SQLException {
        var sex = cs.getInt(i);
        if (sex != 1 && sex != 2) {
            return null;
        }
        return GenderEnum.getGenderById(sex);
    }
}
