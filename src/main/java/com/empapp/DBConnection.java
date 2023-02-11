package com.empapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public static final String url = "jdbc:mysql://localhost:3306/employeedb";
    public static final String name = "root";
    public static final String password = "root";
    static Connection connection;

    public static Connection createDBConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,name,password);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
        return connection;
    }

}
