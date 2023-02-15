package com.emailer;

import com.emailer.conection.Configuration;
import com.emailer.fields.Fields;
import com.emailer.inter.Inter;
import com.mysql.cj.xdevapi.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbImply implements Inter {
    @Override
    public List<Fields> selectByTable(String table) {
        List<Fields> fields = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = Configuration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM " + table + ';');
            while (resultSet.next()) {
                Fields field = new Fields();
                field.setId(resultSet.getInt("id"));
                field.setTo(resultSet.getString("email"));
                fields.add(field);
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return fields;
        }
    }
}
