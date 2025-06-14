import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Users {
    private String last_name, first_name, middle_name, nationality, email, phone;

    // Constructor
    public Users(String last_name, String first_name, String middle_name, 
                 String nationality, String email, String phone) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.nationality = nationality;
        this.email = email;
        this.phone = phone;
    }

    // Method to insert user details into the database
    public void insertUser() {
        String query = "INSERT INTO users (last_name, first_name, middle_name, nationality, email, phone) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, last_name);
            pstmt.setString(2, first_name);
            pstmt.setString(3, middle_name);
            pstmt.setString(4, nationality);
            pstmt.setString(5, email);  // Corrected index to 5
            pstmt.setString(6, phone);   // Corrected index to 6

            pstmt.executeUpdate();
            System.out.println("User details inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
