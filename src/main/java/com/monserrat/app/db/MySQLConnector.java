package com.monserrat.app.db;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class MySQLConnector {
    private String url = "jdbc:mysql://127.0.0.1:3306/monserrat";
    private String username = "root";
    private String password = "root";


    public Statement connectDb() {
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("[SUCCESS] - Connected to the database!");
            Statement statement = connection.createStatement();
            return statement;
            
        } catch (Exception e) {
            System.err.println("Connection error: " + e.getMessage());
        }

        return null;

    }

    public PreparedStatement connectPreparedDb(String query){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("[SUCCESS] - Connected to the database!");
            PreparedStatement ps = connection.prepareStatement(query);
            return ps;
            
        } catch (Exception e) {
            System.err.println("prepared connection error: " + e.getMessage());
        }
        return null;

    }
    
}
