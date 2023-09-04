package com.example.sumprofiles;

import java.sql.*;
import java.util.ArrayList;

public class workBD {

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?autoReconnect=true&useSSL=false", "root", "1111");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Profile> getProfiles() throws SQLException {
        ArrayList<Profile> profiles = new ArrayList<>();

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?autoReconnect=true&useSSL=false", "root", "1111");;
        String zapros = "select * from UserProfileMoney";

        PreparedStatement statement = connection.prepareStatement(zapros);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            profiles.add(new Profile(resultSet.getString(1),resultSet.getInt(2)));
        }
        return profiles;
    }
}
