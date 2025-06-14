import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reservations {
    private int flight_number, seat_number, user_id;
    private String passenger_firstname, passenger_lastname;

    // Constructor with flight_number
    public Reservations(int flight_number, String passenger_firstname, 
                        String passenger_lastname, int seat_number, int user_id) {
        this.flight_number = flight_number;
        this.passenger_firstname = passenger_firstname;
        this.passenger_lastname = passenger_lastname;
        this.seat_number = seat_number;
        this.user_id = user_id;
    }

    // Insert reservation into the database
    public void insertReservation() {
        String query = "INSERT INTO reservations (flight_number, passenger_firstname, passenger_lastname, seat_number, user_id) " +
                       "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, flight_number);  // Set flight_number parameter
            pstmt.setString(2, passenger_firstname);
            pstmt.setString(3, passenger_lastname);
            pstmt.setInt(4, seat_number);
            pstmt.setInt(5, user_id);

            pstmt.executeUpdate();
            System.out.println("Reservation inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting reservation: " + e.getMessage());
        }
    }
}
