package com.example.erasyldiplomapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    private final String url = "jdbc:postgresql://localhost:5432/erassyl";
    private final String user = "postgres";
    private final String password = "era123";
    public Connection databaseLink;
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            databaseLink = DriverManager.getConnection(url, user, password);
            System.out.println("db connected");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}
