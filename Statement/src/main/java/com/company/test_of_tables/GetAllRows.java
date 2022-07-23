package com.company.test_of_tables;

import com.company.connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GetAllRows {
    public static void main(String[] args) {
        Statement statement = null;
        try {
            JDBC.connect();
            statement = JDBC.connection.createStatement();

            // authors

            String getAllAuthors = "SELECT * FROM Authors";
            ResultSet resultSet = statement.executeQuery(getAllAuthors);
            printTableName("Authors");
            while (resultSet.next()) {
                int id = resultSet.getInt("authorID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                printTableRow(Integer.toString(id), firstName, lastName);
            }

            // publishers

            String getAllPublishers = "SELECT * FROM Publishers";
            resultSet = statement.executeQuery(getAllPublishers);
            printTableName("Publishers");
            while (resultSet.next()) {
                int id = resultSet.getInt("publisherID");
                String publisherName = resultSet.getString("publisherName");
                printTableRow(Integer.toString(id), publisherName);
            }

            // authorISBN

            String getAllAuthorISBN = "SELECT * FROM authorISBN";
            resultSet = statement.executeQuery(getAllAuthorISBN);
            printTableName("athorISBN");
            while (resultSet.next()) {
                int id = resultSet.getInt("authorID");
                String isbn = resultSet.getString("isbn");
                printTableRow(Integer.toString(id), isbn);
            }

            // Titles

            String getAllTitles = "SELECT * FROM Titles";
            resultSet = statement.executeQuery(getAllTitles);
            printTableName("Titles");
            List<String[]> titles = new ArrayList<>();
            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                int editionNumber = resultSet.getInt("editionNumber");
                String year = resultSet.getString("year");
                int publisherID = resultSet.getInt("publisherID");
                double price = resultSet.getDouble("price");
                titles.add(new String[]{isbn, title, Integer.toString(editionNumber), year, Integer.toString(publisherID), Double.toString(price)});
//                printTableRow(isbn, title, Integer.toString(editionNumber), year, Integer.toString(publisherID), Double.toString(price));
            }
            printTitles(titles);

        } catch (SQLException e) {
            // TODO: 02/02/2022
            // Handle errors for JDBC
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }

    private static void printTitles(List<String[]> titles) {
        int[] columnLength = new int[6];
        for (int i = 0; i < columnLength.length; i++) {
            int max = 0;
            for (String[] column : titles) {
                max = Math.max(column[i].length(), max);
            }
            columnLength[i] = max;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : columnLength) {
            sb.append("%").append(i+2).append("s");
        }
        sb.append("\n");
        String str = sb.toString();
        for (String[] row : titles) {
            System.out.printf(str, row[0],row[1],row[2],row[3],row[4],row[5]);
        }
    }

    private static void printTableRow(String... data) {
        for (String column : data) {
            System.out.print(column + "\t");
        }
        System.out.println();
    }


    private static void printTableName(String title) {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("\t" + title);
        System.out.println("------------------------------");
        System.out.println();
    }
}
