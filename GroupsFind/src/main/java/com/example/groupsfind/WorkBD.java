package com.example.groupsfind;

import java.sql.*;
import java.util.ArrayList;

public class WorkBD {
    private  static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?autoReconnect=true&useSSL=false", "root", "1111");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Group> getTextInBD() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?autoReconnect=true&useSSL=false", "root", "1111");
        ArrayList<Group> groups = new ArrayList<>();
        String zapros = "select * from GroupsTable";
        PreparedStatement statement = connection.prepareStatement(zapros);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
           groups.add(new Group(resultSet.getString(1),resultSet.getString(2)));
        }
        return groups;
    }
}
