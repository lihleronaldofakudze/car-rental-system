import java.util.Scanner;
import java.sql.*;

public class Car {
    Scanner input = new Scanner(System.in);
    Connection connection;
    Statement statement;

    int id;
    String number;
    String type;
    String category;
    String description;
    int ownerId;
    String password;

    public Car() {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car(int id, String number, String type, String category, String description, int ownerId, String password) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.category = category;
        this.description = description;
        this.ownerId = ownerId;
        this.password = password;
    }

    public void menu() {
        System.out.println("Cars Management Panel : ");
        System.out.println("\t 1. Add New Car");
        System.out.println("\t 2. Update Existing Car");
        System.out.println("\t 3. Delete Car");
        System.out.println("\t 4. View Available Cars");
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
            System.out.println("Exiting...");
            System.exit(0);
        } else {
            System.out.println("Invalid Response");
            menu();
            System.exit(0);
        }
    }

    public void add() {
        try {
            System.out.println("Please all required detail. (Adding New Car)");
            System.out.print("\t Enter Car Number : ");
            this.number = input.next();

            System.out.print("\t Enter Car Type : ");
            this.type = input.next();

            System.out.print("\t Enter Car Category : ");
            this.category = input.next();

            System.out.print("\t Enter Car Description : ");
            this.description = input.next();

            System.out.print("\t Enter Car Owner Id : ");
            this.ownerId = Integer.parseInt(input.next());

            statement = connection.createStatement();
            String sql = "INSERT INTO Cars (id, car_number, type, category, description, owner_id)" +
                    "VALUES (" + 0 + "," + Integer.parseInt(this.number) + ", '" + this.type + "', '" + this.category
                    + "','" + this.description + "','" + this.ownerId + "')";
            statement.executeUpdate(sql);
            System.out.println("Inserted record into the table cars...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void update() {
        try {
            System.out.println("Please all required details. (Update Existing Car)");
            System.out.print("\t Enter Car ID : ");
            this.id = Integer.parseInt(input.next());

            System.out.print("\t Enter Car Number : ");
            this.number = input.next();

            System.out.print("\t Enter Type : ");
            this.type = input.next();

            System.out.print("\t Enter Category : ");
            this.category = input.next();

            System.out.print("\t Enter Description : ");
            this.description = input.next();

            System.out.print("\t Enter Owner Id : ");
            this.ownerId = Integer.parseInt(input.next());

            statement = connection.createStatement();
            String sql = "UPDATE Cars SET car_number = " + Integer.parseInt(this.number) + ", type = '" + this.type
                    + "', category = '" + this.category + "', description = '" + this.description + "', owner_id = "
                    + this.ownerId + " WHERE id = " + this.id;
            statement.executeUpdate(sql);
            System.out.println("Updated a record into the table cars...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void delete() {
        try {
            System.out.println();
            System.out.println("Please all required details. (Delete Car)");
            System.out.print("\t Enter Car Id : ");
            this.id = Integer.parseInt(input.next());

            String sql = "DELETE FROM Cars WHERE id = " + this.id + "";
            statement.executeUpdate(sql);
            System.out.println("Deleted a record into the table cars...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void view() {
        try {
            String query = "SELECT id, car_number, type, category, description, owner_id FROM Cars";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("All Cars");
            System.out.println("========");
            while (resultSet.next()) {
                System.out.print("[ID]: " + resultSet.getInt("id"));
                System.out.print(", [CAR NUMBER]: " + resultSet.getInt("car_number"));
                System.out.print(", [TYPE]: " + resultSet.getString("type"));
                System.out.print(", [CATEGORY]: " + resultSet.getString("category"));
                System.out.print(", [DESCRIPTION]: " + resultSet.getString("description"));
                System.out.println(", [OWNER ID]: " + resultSet.getInt("owner_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
