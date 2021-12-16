package com.wenner.it.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

    private static Connection connection;

    static {
       try{
           Class.forName("com.mysql.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "wenner");
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public static Connection getConnection() {
        return connection;
    }
}
