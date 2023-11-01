package com.example.javawebproject1.example.dao;


import com.example.javawebproject1.example.pojo.Article;
import com.example.javawebproject1.example.until.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
    public List<Article> get(Integer size) {
        List<Article> list = new ArrayList<>();
        String sql = "select aid,title,time,picture from article order by aid desc limit ?";
        try {
            list=queryRunner.query(sql,new BeanListHandler<Article>(Article.class),size);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public Article getByAid(Integer aid) {
        Article article = null;
        String sql = "select aid,title,time,picture,content,video,kid from article where aid= ?";
        try {
            article=queryRunner.query(sql,new BeanHandler<Article>(Article.class),aid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return article;
    }
    public List<Article> getByKid(Integer kid) {
        List<Article> list = new ArrayList<>();
        String sql = "select aid,title,time,picture from article where kid=? order by aid desc";
        try {
            list=queryRunner.query(sql,new BeanListHandler<Article>(Article.class),kid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
