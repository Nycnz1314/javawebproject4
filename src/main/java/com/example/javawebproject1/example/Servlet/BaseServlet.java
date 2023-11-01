package com.example.javawebproject1.example.Servlet;

import com.alibaba.fastjson2.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //设置编码
    req.setCharacterEncoding("utf-8");
    resp.setContentType("text/html;charset=utf-8");
    //设置跨域
    resp.setHeader("Access-Control-Allow-Origin","*");
    //获取请求的url
    String url=req.getRequestURI();
    //获取调用的方法名
    int i = url.lastIndexOf("/");
    String methodName = url.substring(i + 1);
    //调用子类方法
        Class<? extends BaseServlet> cls = this.getClass();
        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            Object result = method.invoke(this, req, resp);
            //获取方法的返回值,转换为JSON数据
            if(result!=null){resp.getWriter().println(JSON.toJSONString(result));}
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
