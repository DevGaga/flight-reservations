import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Handler handler = new Handler();  
        Scanner scanner = new Scanner(System.in);  

        while (true) {  
            System.out.println("\nSelect an option:");
            System.out.println("1. Search for available flights");
            System.out.println("2. Search for Flights by Destination");
            System.out.println("3. Add Reservation");
            System.out.println("4. Add User");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {  
                System.out.println("Invalid input! Please enter a valid option.");
                scanner.next();  
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Fetching available flights...");
                    handler.fetchFlights();  // Call to fetch and display available flights
                    break;

                case 2:
                    System.out.print("Enter flight destination: "); // Prompt for destination
                    String destination = scanner.nextLine(); // Read destination input
                    System.out.println("Searching for flights to " + destination + "...");
                    handler.searchFlightsByDestination(destination); // Call to search by destination
                    break;

                case 3:
                    System.out.println("Enter reservation details:");

                    System.out.print("Flight Number: "); 
                    int flightNumber = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Passenger First Name: "); 
                    String firstName = scanner.nextLine();

                    System.out.print("Passenger Last Name: "); 
                    String lastName = scanner.nextLine();

                    System.out.print("Seat Number: "); 
                    int seatNumber = scanner.nextInt();
                    scanner.nextLine();  

                    System.out.print("User ID: "); 
                    int userid = scanner.nextInt(); 
                    scanner.nextLine();  

                    Reservations reservation = new Reservations(flightNumber, firstName, lastName, seatNumber, userid);
                    handler.addReservation(reservation); 
                    System.out.println("Reservation added successfully.");
                    break;

                case 4:
                    System.out.print("First Name: ");
                    String userFirstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String userLastName = scanner.nextLine();
                    System.out.print("Middle Name: ");
                    String middleName = scanner.nextLine();
                    System.out.print("Nationality: ");
                    String nationality = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();

                    Users user = new Users(userLastName, userFirstName, middleName, nationality, email, phone);
                    handler.addUser(user);
                    System.out.println("User added successfully.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
