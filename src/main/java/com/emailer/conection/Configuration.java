package com.emailer.conection;
import java.sql.Connection;
import java.sql.DriverManager;
public class Configuration {
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(System.getenv("DB"), System.getenv("DBUser"), System.getenv("DBpass"));

        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
