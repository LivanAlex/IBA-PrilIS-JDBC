package com.company.query;

import com.company.connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// Добавить нового Publisher
public class Task07 {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter publisher name:");
            String publisherName = scanner.nextLine();
            JDBC.connect();
            Statement statement = JDBC.connection.createStatement();
            String query = "INSERT INTO Publishers (publisherName) VALUE ('" +  publisherName +"');";
            statement.executeUpdate(query);
            System.out.println("Operation completed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBC.close();
        }
    }
}
