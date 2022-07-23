package com.company.test_of_tables;


import com.company.connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestOfTables {
    public static void main(String[] args) {
        Statement statement = null;
        try {
            System.out.println("This will DELETE all data, do you want to continue? (y/n) ");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            if (userInput.toLowerCase().equals("y")) {
                // open connection
                JDBC.connect();
                statement = JDBC.connection.createStatement();

                // drop tables
                String dropAuthors = "DROP TABLE IF EXISTS authors";
                statement.executeUpdate(dropAuthors);
                String dropTitles = "DROP TABLE IF EXISTS titles";
                statement.executeUpdate(dropTitles);
                String dropPublishers = "DROP TABLE IF EXISTS publishers";
                statement.executeUpdate(dropPublishers);
                String dropAuthorIsbn = "DROP TABLE IF EXISTS authorisbn";
                statement.executeUpdate(dropAuthorIsbn);
                System.out.println("Data deleted");

                // create tables

                String authorsTable = "CREATE TABLE Authors " +
                        "(authorID INTEGER NOT NULL AUTO_INCREMENT, " +
                        " firstName CHAR(20), " +
                        " lastName CHAR(20), " +
                        " PRIMARY KEY (authorID))";
                statement.executeUpdate(authorsTable);
                System.out.println("Created Authors table");

                String titlesTable = "CREATE TABLE Titles " +
                        "(isbn CHAR(13) not NULL, " +
                        " title VARCHAR(255), " +
                        " editionNumber INTEGER, " +
                        " year CHAR(4), " +
                        " publisherID INTEGER REFERENCES Publishers(publisherID), " +
                        " price DECIMAL(8,2), " +
                        " PRIMARY KEY (isbn))";

                statement.executeUpdate(titlesTable);
                System.out.println("Created Titles table");

                String publishersTable = "CREATE TABLE Publishers " +
                        "(publisherID INTEGER NOT NULL AUTO_INCREMENT, " +
                        " publisherName CHAR(100), " +
                        " PRIMARY KEY (publisherID))";

                statement.executeUpdate(publishersTable);
                System.out.println("Created Publishers table");

                String authorISBNTable = "CREATE TABLE authorISBN " +
                        "(authorID INTEGER REFERENCES Authors(authorID), " +
                        " isbn CHAR(10) REFERENCES Titles(isbn))";

                statement.executeUpdate(authorISBNTable);
                System.out.println("Created authorISBN table");

                InsertTestData.updateTables(statement);
            }
        } catch (SQLException e) {
            // TODO: 02/02/2022
            // Handle errors for JDBC

            e.printStackTrace();
        } finally {
            // Finally block, used to close resources
            if (statement != null) {
                JDBC.close();
            }
        }

    }
}
