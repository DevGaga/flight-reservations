
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

 public class App {
    public static void main(String[] args) throws Exception {
        

        String url = "jdbc:mysql://localhost:3306/airlines";
        String username = "root";
        String password = "0962594409@Rapheal";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully!");
           
            
           
            // Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}



