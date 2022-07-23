package com.company.query;

import com.company.connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// Выполните добавление Нового автора в БД
public class Task05 {
    public static void main(String[] args) {
       run();

    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter author first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter author last name:");
        String lastName = scanner.nextLine();

        try {
            JDBC.connect();
            Statement statement = JDBC.connection.createStatement();
            String query = "INSERT INTO Authors(FIRSTNAME, LASTNAME) " +
                    "VALUES ('" + firstName + "','" + lastName + "')";
            int num = statement.executeUpdate(query);
            if(num == 0){
                throw new SQLException("Can't create author");
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
