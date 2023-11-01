package com.example.javawebproject1.example.Servlet;

import com.example.javawebproject1.example.Service.ArticleService;
import com.example.javawebproject1.example.pojo.Article;
import com.example.javawebproject1.example.pojo.Result;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@WebServlet("/article/*")
public class ArticleServlet extends BaseServlet{
    private ArticleService articleService = new ArticleService();
    public Object getByKid(HttpServletRequest request, HttpServletResponse response){
        String kid = request.getParameter("kid");
        List<Article> list = articleService.getByKid(Integer.parseInt(kid));
        return Result.success(list);
    }
    public Object getByAid(HttpServletRequest request, HttpServletResponse response){
        String aid=request.getParameter("aid");
        Article article = articleService.getByAid(Integer.parseInt(aid));
        return Result.success(article);
    }
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = request.getParameter("fileName");
            FileInputStream fis = new FileInputStream("E:\\java项目开发实验报告\\uploadFile\\" + fileName);
                ServletOutputStream out = response.getOutputStream();
                IOUtils.copy(fis,out);
    }
}
