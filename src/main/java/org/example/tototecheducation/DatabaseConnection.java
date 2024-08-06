package org.example.tototecheducation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection databaseConnection;

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/myDB";
        String user = "root";
        String password = "sir2kalFOUR!";

        databaseConnection = DriverManager.getConnection(url, user, password);
        return databaseConnection;
    }



}
