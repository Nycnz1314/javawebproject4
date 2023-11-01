package com.example.javawebproject1.example.dao;

import com.example.javawebproject1.example.pojo.Article;
import com.example.javawebproject1.example.pojo.Kind;
import com.example.javawebproject1.example.until.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KindDAO {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
    public List<Kind> get() {
        List<Kind> list = new ArrayList<>();
        String sql = "select kid,content from kind";
        try {
            list=queryRunner.query(sql,new BeanListHandler<Kind>(Kind.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
