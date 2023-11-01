package com.example.javawebproject1.example.Service;

import com.example.javawebproject1.example.dao.ArticleDAO;
import com.example.javawebproject1.example.dao.ArticleDAO;
import com.example.javawebproject1.example.pojo.Article;

import java.util.List;

public class ArticleService {
    private ArticleDAO articleDAO = new ArticleDAO();
    public List<Article> getByKid(int kid){
        return articleDAO.getByKid(kid);
    }
    public Article getByAid(Integer aid){
        return articleDAO.getByAid(aid);
    }
}
