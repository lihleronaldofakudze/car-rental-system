import java.util.Scanner;
import java.sql.*;

public class Route {
    Scanner input = new Scanner(System.in);
    Connection connection;
    Statement statement;

    int id;
    String type;
    String description;
    String name;

    public Route() {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Route(int id, String type, String description, String name) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.name = name;
    }

    public void menu() {
        System.out.println("Routes Management Panel : ");
        System.out.println("\t 1. Add New Route");
        System.out.println("\t 2. Update Existing Route");
        System.out.println("\t 3. Delete Route");
        System.out.println("\t 4. View Available Routes");
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
            System.out.println();
            menu();
        }
    }

    public void add() {
        try {
            System.out.println("Please all required details. (Adding New Route)");
            System.out.print("\t Enter Type : ");
            this.type = input.next();

            System.out.print("\t Enter Description : ");
            this.description = input.next();

            System.out.print("\t Enter Name : ");
            this.name = input.next();

            statement = connection.createStatement();
            String sql = "INSERT INTO Routes (id, type, description, name)" +
                    "VALUES (" + 0 + ",'" + this.type + "', '" + this.description + "', '" + this.name + "')";
            statement.executeUpdate(sql);
            System.out.println("Inserted record into the table routes...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void update() {
        try {
            System.out.println("Please all required details. (Updating Existing Route)");

            System.out.print("\t Enter Route Id : ");
            this.id = Integer.parseInt(input.next());

            System.out.print("\t Enter Type : ");
            this.type = input.next();

            System.out.print("\t Enter Description : ");
            this.description = input.next();

            System.out.print("\t Enter Name : ");
            this.name = input.next();

            statement = connection.createStatement();
            String sql = "UPDATE Routes SET type = '" + this.type + "', description = '" + this.description
                    + "', name = '" + this.name + "' WHERE id = " + this.id;
            statement.executeUpdate(sql);
            System.out.println("Updated record into the table routes...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void delete() {
        try {
            System.out.println();
            System.out.println("Please all required details. (Delete Route)");
            System.out.print("\t Enter Route Id : ");
            this.id = Integer.parseInt(input.next());

            String sql = "DELETE FROM Routes WHERE id = " + this.id + "";
            statement.executeUpdate(sql);
            System.out.println("Deleted a record into the table routes...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void view() {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();

            String query = "SELECT id, type, description, name FROM Routes";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("All Routes");
            System.out.println("==========");
            while (resultSet.next()) {
                System.out.print("[ID]: " + resultSet.getInt("id"));
                System.out.print(", [TYPE]: " + resultSet.getString("type"));
                System.out.print(", [DESCRIPTION]: " + resultSet.getString("description"));
                System.out.println(", [NAME]: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
