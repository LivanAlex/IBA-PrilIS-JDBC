package com.company.query;

import com.company.connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// Добавить authorISBN (при передачи VALUES необходимо параметр autorID так же сделать подзапросом с указанием имени и фамилии)
public class Task09 {
    public static void main(String[] args) {
        run();
    }

    public static void run() {

        try {
            Scanner scanner = new Scanner(System.in);
            String firstName, lastName, isbn, authorID, query;
            System.out.println("Enter author first name:");
            firstName = scanner.nextLine();
            System.out.println("Enter author last name:");
            lastName = scanner.nextLine();
            System.out.println("Enter isbn:");
            isbn = scanner.nextLine();
            JDBC.connect();
            Statement statement = JDBC.connection.createStatement();
            authorID = getAuthorID(firstName, lastName, statement);
            query = String.format("INSERT INTO authorISBN(authorID, isbn) VALUE ('%s', '%s');", authorID,isbn);
            statement.executeUpdate(query);
            System.out.println("Operation completed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBC.close();
        }


    }

    private static String getAuthorID(String firstName, String lastName, Statement statement) throws SQLException {
        String authorID = "";
        String query = String.format("SELECT * FROM Authors WHERE firstName = '%s' AND lastName = '%s';", firstName, lastName);
        ResultSet resultSet = statement.executeQuery(query);
        if(resultSet.next()){
            authorID = resultSet.getString(1);
        }
        return authorID;
    }
}
