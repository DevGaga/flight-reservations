import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String URL = "jdbc:mysql://localhost:3306/airlines";
    private static final String USER = "root";
    private static final String PASSWORD = "0962594409@Rapheal";

    // Private constructor to prevent instantiation
    private DBconnection() {}

    // Static method to get a database connection
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
            throw e;
        }
    }
}
