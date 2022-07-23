package com.company.query;

import com.company.connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Сделайте выборку по авторам, отсортировав по их Имени и Фамилии
public class Task01 {
    public static void main(String[] args) {
       run();
    }

    public static void run() {
        String query = "SELECT * FROM Authors ORDER BY firstName, lastName";
        try{
            JDBC.connect();
            Statement statement = JDBC.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int id = resultSet.getInt("authorID");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
