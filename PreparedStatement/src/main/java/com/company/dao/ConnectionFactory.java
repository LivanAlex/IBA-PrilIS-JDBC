
package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(
                    "jdbc:mysql://192.168.0.200:3306/ibapst?useUnicode=true&characterEncoding=UTF-8&useSSL=false",
                    "root",
                    "rootroot");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e);
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
        return c;
    }
}