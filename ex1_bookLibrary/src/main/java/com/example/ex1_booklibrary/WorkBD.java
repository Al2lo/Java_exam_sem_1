package com.example.ex1_booklibrary;

import java.sql.*;
import java.util.ArrayList;

public class WorkBD {

    private static Connection connection;
    public static int count = 0;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?autoReconnect=true&useSSL=false", "root", "1111");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


        private static void connect() throws SQLException {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?autoReconnect=true&useSSL=false", "root", "1111");
        }

        private static void closeConnect() throws SQLException {
            connection.close();
        }



        public static ArrayList<Book> getAllAutgors() throws SQLException {

            ArrayList<Book> books = new ArrayList<>();
            String zapros = "select * from BookLibrary";
            PreparedStatement statement = connection.prepareStatement(zapros);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                books.add(new Book(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4) ));
            }
            return  books;

        }
}
