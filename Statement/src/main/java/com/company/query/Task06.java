package com.company.query;

import com.company.connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Task06 {
    // Обновите Имя автора по определенному id
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose id of author:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Chose new name of author:");
        String authorName = scanner.nextLine();
        String query = "UPDATE Authors SET firstName = '" + authorName + "' WHERE authorID = " + id + ";";
        try {
            JDBC.connect();
            Statement statement = JDBC.connection.createStatement();
            int status = statement.executeUpdate(query);
            if (status == 0){
                throw new SQLException("Can't update author: ID not found");
            }
            System.out.println("Operation completed");
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
