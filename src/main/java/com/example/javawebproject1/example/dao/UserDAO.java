package com.example.javawebproject1.example.dao;

import com.example.javawebproject1.example.pojo.User;
import com.example.javawebproject1.example.until.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDAO {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
    public User get(String username,String password){
            String sql = "select uid,username,image from user where username=? and password=?";
        try {
            User user = queryRunner.query(sql, new BeanHandler<User>(User.class), username, password);
            if (user!=null){
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void insert(User user){
            String sql = "insert into user(username,password,image,email,type) values (?,?,?,?,?)";
        try {
            queryRunner.update(sql,user.getUsername(),user.getPassword(),user.getImage(),user.getEmail(),1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
