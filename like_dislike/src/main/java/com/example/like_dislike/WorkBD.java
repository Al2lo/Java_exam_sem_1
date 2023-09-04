package com.example.like_dislike;

import java.sql.*;

public class WorkBD {
    private  static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?autoReconnect=true&useSSL=false", "root", "1111");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public static Message getTextInBD() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?autoReconnect=true&useSSL=false", "root", "1111");
        Message message = new Message("",0,0);
        String zapros = "select * from Liked";
        PreparedStatement statement = connection.prepareStatement(zapros);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                message = new Message(resultSet.getString(1),resultSet.getInt(2),resultSet.getInt(3));
            }
            return message;
        }
}

