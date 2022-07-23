import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class Main {
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    private static CallableStatement callableStatement;
    private static ResultSet resultSet;

    public static void main(String[] args) {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("sql");
        URL = resourceBundle.getString("url");
        USER = resourceBundle.getString("user");
        PASSWORD = resourceBundle.getString("password");

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            callableStatement = connection.prepareCall("SELECT * FROM DBO.COUNT_OF_PRODUCTS_BY_MANUFACTURER_WITH_PRICE_HIGHER_THEN(?)");
            callableStatement.setInt(1, 1000);
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
