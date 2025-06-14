import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    // Class fields (private for encapsulation)
    private int flight_id, flight_number, available_seats;
    private String flight_origin, flight_destination, arrival_time, departure_time, passport;

    // Constructor
    public Flight(int flight_id, int flight_number, String flight_origin, 
                  String flight_destination, String arrival_time, 
                  String departure_time, int available_seats, String passport) {
        this.flight_id = flight_id;
        this.flight_number = flight_number;
        this.flight_origin = flight_origin;
        this.flight_destination = flight_destination;
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
        this.available_seats = available_seats;
        this.passport = passport;
    }

    // Getters and setters
    // ... (existing getters and setters)

    // Fetch flights from the database and return a List of Flight objects
    public static List<Flight> fetchFlights() {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flights";

        try (Connection conn = DBconnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(query)) {

            while (resultSet.next()) {
                Flight flight = new Flight(
                    resultSet.getInt("flight_id"),
                    resultSet.getInt("flight_number"),
                    resultSet.getString("flight_origin"),
                    resultSet.getString("flight_destination"),
                    resultSet.getString("arrival_time"),
                    resultSet.getString("departure_time"),
                    resultSet.getInt("available_seats"),
                    resultSet.getString("passport")
                );
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    // Fetch flights by destination
    public static List<Flight> fetchFlightsByDestination(String destination) {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flights WHERE flight_destination = ?"; // Use parameterized query

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, destination); // Set destination parameter

            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Flight flight = new Flight(
                        resultSet.getInt("flight_id"),
                        resultSet.getInt("flight_number"),
                        resultSet.getString("flight_origin"),
                        resultSet.getString("flight_destination"),
                        resultSet.getString("arrival_time"),
                        resultSet.getString("departure_time"),
                        resultSet.getInt("available_seats"),
                        resultSet.getString("passport")
                    );
                    flights.add(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    // Display flight information for debugging or testing
    public void displayFlightInfo() {
        System.out.println("Flight ID: " + flight_id);
        System.out.println("Flight Number: " + flight_number);
        System.out.println("Origin: " + flight_origin);
        System.out.println("Destination: " + flight_destination);
        System.out.println("Arrival: " + arrival_time);
        System.out.println("Departure: " + departure_time);
        System.out.println("Available Seats: " + available_seats);
        System.out.println("Passport: " + passport);
        System.out.println("-----------------------------");
    }
}
