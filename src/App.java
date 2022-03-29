import java.sql.*;
import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);
    static Car car;
    static Booking booking;
    static Passenger passenger;
    static Route route;
    static Driver driver;
    static Role role;
    static Administrator administrator;

    public static void main(String[] args) {
        // Classes in play
        car = new Car();
        booking = new Booking();
        passenger = new Passenger();
        route = new Route();
        driver = new Driver();
        role = new Role();
        administrator = new Administrator();

        // Database Connection
        Connection connection = DatabaseConnection.getConnection();
        login(connection);

    }

    public static void login(Connection connection) {

        // System In Progress
        System.out.println("Welcome back System Administration");
        System.out.println("\t 1. Login");
        System.out.println("\t 0. Exit");

        // Login Response
        System.out.print("Your response : ");
        int loginResponse = Integer.parseInt(input.next());
        System.out.println();

        if (loginResponse == 1) {
            System.out.print("Enter your username : ");
            String username = input.next();
            System.out.print("Enter your password : ");
            String password = input.next();
            System.out.println();
            boolean isLogged = Administrator.login(username, password);
            int selectedTopic = menu(isLogged);

            if (selectedTopic == 1) {
                car.menu();
            } else if (selectedTopic == 2) {
                booking.menu();
            } else if (selectedTopic == 3) {
                passenger.menu();
            } else if (selectedTopic == 4) {
                route.menu();
            } else if (selectedTopic == 5) {
                driver.menu();
            } else if (selectedTopic == 6) {
                role.menu();
            } else if (selectedTopic == 7) {
                administrator.menu();
            } else if (selectedTopic == 0) {
                System.out.println("Thank you, for using the system proper. GoodBye");
                System.exit(0);
            } else {
                System.out.println("Invalid Input, please try again");
                System.exit(0);
            }

        } else if (loginResponse == 0) {
            System.out.println("Thank you, for using the system proper. GoodBye");
            System.exit(0);
        } else {
            System.out.println("Invalid response, please try again");
            System.out.println();
            login(connection);
        }
    }

    public static int menu(boolean isLogged) {
        if (isLogged == true) {
            System.out.println("Administrator Main Menu : ");
            System.out.println("\t 1. Car Management");
            System.out.println("\t 2. Booking Management");
            System.out.println("\t 3. Passenger Management");
            System.out.println("\t 4. Car Routes Management");
            System.out.println("\t 5. Drivers Management");
            System.out.println("\t 6. Role Management");
            System.out.println("\t 7. Administrator Management");
            System.out.println("\t 0. Exit");

            System.out.print("Your choice : ");
            int menuChoose = Integer.parseInt(input.next());
            System.out.println();
            return menuChoose;
        } else {
            System.out.println("You are not logged in, please try again.");
            System.exit(0);
            return 0;
        }
    }
}
