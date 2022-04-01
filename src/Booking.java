import java.util.Scanner;
import java.sql.*;

public class Booking {
    Scanner input = new Scanner(System.in);
    Connection connection;
    Statement statement;

    int id;
    String title;
    String description;
    String type;
    String ticket;
    String date;

    public Booking() {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Booking(int id, String title, String description, String type, String ticket, String date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.ticket = ticket;
        this.date = date;
    }

    public void menu() {
        System.out.println("Bookings Management Panel : ");
        System.out.println("\t 1. Add New Booking");
        System.out.println("\t 2. Update Existing Booking");
        System.out.println("\t 3. Delete Booking");
        System.out.println("\t 4. View Available Bookings");
        System.out.println("\t 0. Exit");
        System.out.print("Your Response : ");
        int response = Integer.parseInt(input.next());
        System.out.println();

        if (response == 1) {
            add();
            System.out.println();
            menu();
        } else if (response == 2) {
            view();
            update();
            System.out.println();
            menu();
        } else if (response == 3) {
            view();
            delete();
            System.out.println();
            menu();
        } else if (response == 4) {
            view();
            System.out.println();
            menu();
        } else if (response == 0) {
            System.out.println("Thank you for using our service!");
            System.exit(0);
        } else {
            System.out.println("Invalid Response");
            System.out.println();
            menu();
        }
    }

    public void add() {
        try {
            System.out.println("Please all required details. (Adding New Booking)");
            System.out.print("\t Enter Title : ");
            this.title = input.next();

            System.out.print("\t Enter Description : ");
            this.description = input.next();

            System.out.print("\t Enter Type : ");
            this.type = input.next();

            System.out.print("\t Enter Ticket : ");
            this.ticket = input.next();

            System.out.print("\t Enter Booking Date : ");
            this.date = input.next();

            statement = connection.createStatement();
            String sql = "INSERT INTO Bookings (id, title, description, type, ticket, booking_date)" +
                    "VALUES (" + 0 + ",'" + this.title + "', '" + this.description + "', '" + this.type + "','"
                    + this.ticket + "','" + this.date + "')";
            statement.executeUpdate(sql);
            System.out.println("Inserted record into the table bookings...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void update() {
        try {
            System.out.println("Please all required details. (Updating Existing Booking)");
            System.out.print("\t Enter Id : ");
            this.id = Integer.parseInt(input.next());

            System.out.print("\t Enter Title : ");
            this.title = input.next();

            System.out.print("\t Enter Description : ");
            this.description = input.next();

            System.out.print("\t Enter Type : ");
            this.type = input.next();

            System.out.print("\t Enter Ticket : ");
            this.ticket = input.next();

            System.out.print("\t Enter Booking Date : ");
            this.date = input.next();

            statement = connection.createStatement();
            String sql = "UPDATE Bookings SET title = '" + this.title + "', description = '" + this.description
                    + "', type = '" + this.type + "', ticket = '" + this.ticket + "', booking_date = '" + this.date
                    + "' WHERE id = " + this.id;
            statement.executeUpdate(sql);
            System.out.println("Updated record into the table bookings...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void delete() {
        try {
            System.out.println();
            System.out.println("Please all required details. (Delete Booking)");
            System.out.print("\t Enter Booking Id : ");
            this.id = Integer.parseInt(input.next());

            String sql = "DELETE FROM Bookings WHERE id = " + this.id + "";
            statement.executeUpdate(sql);
            System.out.println("Deleted a record into the table bookings...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void view() {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();

            String query = "SELECT id, title, description, type, ticket, booking_date FROM Bookings";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("All Bookings");
            System.out.println("=============");
            while (resultSet.next()) {
                System.out.print("[ID]: " + resultSet.getInt("id"));
                System.out.print(", [TITLE]: " + resultSet.getString("title"));
                System.out.print(", [DESCRIPTION]: " + resultSet.getString("description"));
                System.out.print(", [TYPE]: " + resultSet.getString("type"));
                System.out.print(", [TICKET]: " + resultSet.getString("ticket"));
                System.out.println(", [BOOKING DATE]: " + resultSet.getString("booking_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
