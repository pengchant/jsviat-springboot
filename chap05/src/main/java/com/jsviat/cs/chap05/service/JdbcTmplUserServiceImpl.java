package com.jsviat.cs.chap05.service;

import com.jsviat.cs.chap05.dic.GenderEnum;
import com.jsviat.cs.chap05.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class JdbcTmplUserServiceImpl implements JdbcTmplUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> getUserRowMapper() {
        return (ResultSet rs, int rownum) -> {
            var user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            int genderId = rs.getInt("gender");
            var gender = GenderEnum.getGenderById(genderId);
            user.setGender(gender);
            user.setNote(rs.getString("note"));
            return user;
        };
    }

    @Override
    public User getUser(Long id) {
        var sql = "select id, user_name, gender, note from t_user where id = ?";
        var user = jdbcTemplate.queryForObject(sql, getUserRowMapper(), id);
        return user;
    }

    @Override
    public List<User> findUsers(String username, String note) {
        var sql = """
                select id, user_name, gender, note from t_user
                where user_name like concat('%', ?, '%')
                and note like concat('%', ?, '%')
                """;
        return jdbcTemplate.query(sql, getUserRowMapper(), username, note);
    }

    @Override
    public int insertUser(User user) {
        var sql = """
                insert into t_user (user_name, gender, note)
                values (?, ?, ?)""";
        return jdbcTemplate.update(sql,
                user.getUsername(), user.getGender().getId(), user.getNote());
    }

    @Override
    public int updateUser(User user) {
        var sql = """
                update t_user set user_name = ?, gender = ?, note = ?
                where id = ?""";
        return jdbcTemplate.update(sql, user.getUsername(),
                user.getGender().getId(), user.getNote(), user.getId());
    }

    @Override
    public int deleteUser(User user) {
        var sql = "delete from t_user where id = ?";
        return jdbcTemplate.update(sql, user.getId());
    }

    @Override
    public User getUser2(Long id) {
        var result = this.jdbcTemplate.execute((StatementCallback<User>) stmt -> {
            var sql1 = "select count(*) total from t_user where id = " + id;
            var rs1 = stmt.executeQuery(sql1);
            while (rs1.next()) {
                var total = rs1.getInt("total");
                System.out.println(total);
            }
            var sql2 = "select id, user_name, gender, note from t_user where id = " + id;
            var rs2 = stmt.executeQuery(sql2);
            User user = null;
            while (rs2.next()) {
                var rowNum = rs2.getRow();
                user = getUserRowMapper().mapRow(rs2, rowNum);
            }
            return user;
        });
        return result;
    }

    @Override
    public User getUser3(Long id) {
        return this.jdbcTemplate.execute((ConnectionCallback<User>) con -> {
            var sql1 = "select count(*) as total from t_user where id = ?";
            var ps1 = con.prepareStatement(sql1);
            ps1.setLong(1, id);
            var res1 = ps1.executeQuery();
            while (res1.next()) {
                System.out.println(res1.getInt("total"));
            }
            var sql2 = "select id, user_name, gender, note from t_user where id = ?";
            var ps2 = con.prepareStatement(sql2);
            ps2.setLong(1, id);
            var rs2 = ps2.executeQuery();
            User user = null;
            while (rs2.next()) {
                var rowNum = rs2.getRow();
                user = getUserRowMapper().mapRow(rs2, rowNum);
            }
            return user;
        });

    }
}
