package com.company.query;

import com.company.connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Task02 {
    // Добавьте нового Издателя (publusher)
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter publisher name:");
            String name = scanner.nextLine();
            JDBC.connect();
            Statement statement = JDBC.connection.createStatement();
            String query = "INSERT INTO Publishers (publisherName) VALUE ('" + name + "')";
            int result = statement.executeUpdate(query);
            if (result == 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            if (e.getMessage() == null) {
                e.printStackTrace();
            } else {
                System.err.println(e.getMessage());
            }
        } finally {
            JDBC.close();
        }
    }
}
