package com.company.connection;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBC {
    public static Connection connection;
    static Attribute grey = Attribute.TEXT_COLOR(100,100,100);
    static Attribute red = Attribute.TEXT_COLOR(255,0,0);

    public static void connect() throws SQLException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        final String driver = resourceBundle.getString("driver");
        final String url = resourceBundle.getString("url");
        final String user = resourceBundle.getString("user");
        final String password = resourceBundle.getString("password");

        try {
            Class.forName(driver);
            System.out.println(Ansi.colorize("Driver registered", grey));
        } catch (ClassNotFoundException e) {
            System.out.println(Ansi.colorize("Driver not found", red));
            e.printStackTrace();
            throw new SQLException();
        }

        connection = DriverManager.getConnection(url, user, password);
        if (connection == null) {
            throw new SQLException();
        } else {
            System.out.println(Ansi.colorize("Successfully connected", grey));
        }
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println(Ansi.colorize("Closing connection", grey));
            }
        } catch (SQLException e) {
            System.out.println(Ansi.colorize("Failed to close connection!", red));
        }
    }

}

