package DBHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String DB_HOST = "mysql.railway.internal";
    private static final int DB_PORT = 3306;
    private static final String DB_NAME = "railway";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "zekoLlbeqGCeXFcpfeDsbElGIRENLCQI";

    private static final String DB_URL = String.format("jdbc:mysql://%s:%d/%s", DB_HOST, DB_PORT, DB_NAME);

    // Load MySQL driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found", e);
        }
    }

    // Method to get a connection
    public static Connection getConnection() throws SQLException {
        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection ok ...");
            return con;
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            throw e;
        }
    }
}
