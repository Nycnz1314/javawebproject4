package com.example.javawebproject1.example.Service;

import com.example.javawebproject1.example.dao.UserDAO;
import com.example.javawebproject1.example.dao.UserDAO;
import com.example.javawebproject1.example.pojo.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    public User login(String username,String password){
        return userDAO.get(username, password);
    }
    public void save(User user){
        userDAO.insert(user);
    }
}
