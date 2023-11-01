package com.example.javawebproject1.example.Service;

import com.example.javawebproject1.example.dao.KindDAO;

import java.util.List;

public class KindService {
    private KindDAO kindDAO = new KindDAO();
    public List getAll(){
        return kindDAO.get();
    }
}
