package com.example.javawebproject1.example.until;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtil {
    public static ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
    public static Connection getConnection(){
        try {
            return comboPooledDataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static DataSource getDataSource() {
        return comboPooledDataSource;
    }
}