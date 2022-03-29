import java.sql.*;
import java.util.Scanner;

public class Driver {
    Scanner input = new Scanner(System.in);
    Connection connection;
    Statement statement;

    int id;
    String name;
    int phoneNumber;
    String address;
    String username;
    String email;
    String password;

    public Driver() {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Driver(int id, String name, int phoneNumber, String address, String username, String email,
            String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public void menu() {
        System.out.println("Drivers Management Panel : ");
        System.out.println("\t 1. Add New Driver");
        System.out.println("\t 2. Update Existing Driver");
        System.out.println("\t 3. Delete Driver");
        System.out.println("\t 4. View Available Drivers");
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
            System.out.println("Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Invalid Response");
            System.out.println();
            menu();
        }
    }

    public void add() {
        try {
            System.out.println("Please all required details. (Adding New Driver)");

            System.out.print("\t Enter Name : ");
            this.name = input.next();

            System.out.print("\t Enter Phone Number : ");
            this.phoneNumber = Integer.parseInt(input.next());

            System.out.print("\t Enter Address : ");
            this.address = input.next();

            System.out.print("\t Enter Email : ");
            this.email = input.next();

            System.out.print("\t Enter Username : ");
            this.username = input.next();

            System.out.print("\t Enter Password : ");
            this.password = input.next();

            statement = connection.createStatement();
            String sql = "INSERT INTO Drivers (id, name, phone_number, email, address, username, password)" +
                    "VALUES (" + 0 + ",'" + this.name + "', " + this.phoneNumber + ", '" + this.email + "','"
                    + this.address + "','" + this.username + "', '" + this.password + "')";
            statement.executeUpdate(sql);
            System.out.println("Inserted record into the table drivers...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void update() {
        try {
            System.out.println("Please all required details. (Updating Existing Driver)");

            System.out.print("\t Enter Name : ");
            this.name = input.next();

            System.out.print("\t Enter Phone Number : ");
            this.phoneNumber = Integer.parseInt(input.next());

            System.out.print("\t Enter Address : ");
            this.address = input.next();

            System.out.print("\t Enter Email : ");
            this.email = input.next();

            System.out.print("\t Enter Username : ");
            this.username = input.next();

            System.out.print("\t Enter Password : ");
            this.password = input.next();

            statement = connection.createStatement();
            String sql = "UPDATE Drivers SET name = '" + this.name + "', phone_number = " + this.phoneNumber
                    + ", email = '" + this.email + "', address = '" + this.address + "', username = '" + this.username
                    + "', password = '" + this.password + "' WHERE id = " + this.id;
            statement.executeUpdate(sql);
            System.out.println("Updated record into the table drivers...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void delete() {
        try {
            System.out.println();
            System.out.println("Please all required details. (Delete Driver)");
            System.out.print("\t Enter Driver Id : ");
            this.id = Integer.parseInt(input.next());

            String sql = "DELETE FROM Drivers WHERE id = " + this.id + "";
            statement.executeUpdate(sql);
            System.out.println("Deleted a record into the table drivers...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void view() {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();

            String query = "SELECT id, name, driver_number, address, email, username, password FROM Drivers";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("All Drivers");
            System.out.println("===========");
            while (resultSet.next()) {
                System.out.print("[ID]: " + resultSet.getInt("id"));
                System.out.print(", [NAME]: " + resultSet.getString("name"));
                System.out.print(", [DRIVER NUMBER]: " + resultSet.getInt("driver_number"));
                System.out.print(", [ADDRESS]: " + resultSet.getString("address"));
                System.out.print(", [EMAIL]: " + resultSet.getString("email"));
                System.out.print(", [USERNAME]: " + resultSet.getString("username"));
                System.out.println(", [PASSWORD]: " + resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
