import java.util.List;  // Import List class // Import ArrayList if needed

public class Handler {
    public void fetchFlights() {
        for (Flight flight : Flight.fetchFlights()) {
            flight.displayFlightInfo();
        }
    }

    public void searchFlightsByDestination(String destination) {
        List<Flight> flights = Flight.fetchFlightsByDestination(destination);
        if (flights.isEmpty()) {
            System.out.println("No flights found to " + destination);
        } else {
            for (Flight flight : flights) {
                flight.displayFlightInfo();
            }
        }
    }

    public void addReservation(Reservations reservation) {
        reservation.insertReservation();
    }

    public void addUser(Users user) {
        user.insertUser();
    }
}
