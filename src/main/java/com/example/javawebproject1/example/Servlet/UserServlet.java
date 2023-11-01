package com.example.javawebproject1.example.Servlet;

import com.example.javawebproject1.example.Service.UserService;
import com.example.javawebproject1.example.pojo.Result;
import com.example.javawebproject1.example.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/user/*")
@MultipartConfig
public class UserServlet extends BaseServlet {
    private UserService userService = new UserService();

    public Result regist(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));

        try {
            Part file = request.getPart("file");
//            file.write("");
            //获取文件原来的名称
            String cd = file.getHeader("Content-Disposition");
            String fileName = cd.substring(cd.lastIndexOf("=") + 2, cd.length() - 1);
            //将上传的文件重命名
            String ext = fileName.substring(fileName.lastIndexOf("."));//获取文件后缀
            String fileNewName = UUID.randomUUID().toString().replaceAll("-", "") + ext;
            file.write("E:\\java项目开发实验报告\\uploadFile" + fileNewName);//上传文件
            user.setImage(fileNewName);
            userService.save(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        return Result.success();
    }

    public Result login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(username, password);
        if(user!=null) return Result.success(user);

        return Result.fail();
    }
}
