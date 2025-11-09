
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static final String url = "jdbc:mysql://localhost:3306/crud";
    private static final String user = "root";
    private static final String password = "";
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        try {
            if (conn == null) {
                // Ensure the MySQL driver class is loaded. With a proper classpath this
                // is optional (JDBC 4+ supports auto-loading), but loading explicitly
                // helps when running from IDEs or custom classloaders.
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException cnfe) {
                    // If the driver class isn't found, throw a clearer SQLException
                    throw new SQLException("MySQL JDBC Driver not found. Make sure mysql-connector-java is on the classpath.", cnfe);
                }

                conn = DriverManager.getConnection(url, user, password);
            }
            return conn;
        } catch (SQLException e) {
            throw new SQLException("Error connecting to the database: " + e.getMessage());
        }
    }
}
