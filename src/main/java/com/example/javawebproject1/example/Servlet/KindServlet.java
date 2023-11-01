package com.example.javawebproject1.example.Servlet;

import com.example.javawebproject1.example.Service.KindService;
import com.example.javawebproject1.example.pojo.Article;
import com.example.javawebproject1.example.pojo.Kind;
import com.example.javawebproject1.example.pojo.Result;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@WebServlet("/kind/*")
public class KindServlet extends BaseServlet{
    private KindService kindService = new KindService();
    public Object getAll(HttpServletRequest request, HttpServletResponse response){
        List<Kind> list = kindService.getAll();
        return Result.success(list);
    }
}
