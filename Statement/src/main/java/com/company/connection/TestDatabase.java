package com.company.connection;

import java.sql.SQLException;

public class TestDatabase {
    public static void main(String[] args) {
        try{
            JDBC.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
