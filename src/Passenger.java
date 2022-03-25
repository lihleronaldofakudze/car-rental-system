import java.sql.*;
import java.util.Scanner;

public class Passenger {
    Scanner input = new Scanner(System.in);
     Connection connection;
     Statement statement;

    int id;
    String name;
    int phoneNumber;
    String address;
    String email;
    String username;
    String password;


    public Passenger () {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }

    public Passenger(int id, String name, int phoneNumber, String address, String email){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void menu () {
        System.out.println("Passenger Management Panel : ");
        System.out.println("\t 1. Add New Passenger");
        System.out.println("\t 2. Update Existing Passenger");
        System.out.println("\t 3. Delete Passenger");
        System.out.println("\t 4. View Available Passengers");
        System.out.println("\t 0. Exit");
        System.out.print("Your Response : ");
        int response = Integer.parseInt(input.next());
        System.out.println();

        if (response == 1) {
            add();
            view();
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
        }   else if (response == 4) {
            view();
            System.out.println();
             menu();
        } else {
            System.exit(0);
        }
    }

    public void add () {
        try {
            System.out.println("Please all required details. (Adding New Passenger)");
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
            String sql = "INSERT INTO Passengers (id, name, phone_number, email, address, username, password)" + 
            "VALUES ("+ 0 +",'"+ this.name +"', " + this.phoneNumber + ", '"+ this.email +"','"+ this.address +"','"+ this.username +"', '"+ this.password +"')";
            statement.executeUpdate(sql);
            System.out.println("Inserted record into the table passengers...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public boolean update (int id, String name, int phoneNumber, String address, String email) {
        return false;
    }

    public void delete () {
        try {
        System.out.println();
        System.out.println("Please all required details. (Delete Passenger)");
        System.out.print("\t Enter Passenger Id : ");
        this.id = Integer.parseInt(input.next());

        String sql = "DELETE FROM Passengers WHERE id = " + this.id+"";
     statement.executeUpdate(sql);
     System.out.println("Deleted a record into the table passengers...");
    } catch (SQLException e) {
        e.printStackTrace();
           System.exit(0);
        }
    }

    public void view () {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();

            String query = "SELECT id, name, phone_number, address, email, username, password FROM Passengers";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("All Passengers");
            System.out.println("=============");
            while (resultSet.next()) {
                System.out.print("[ID]: " + resultSet.getInt("id"));
                System.out.print(", [NAME]: " + resultSet.getString("name"));
                System.out.print(", [PHONE NUMBER]: " + resultSet.getInt("phone_number"));
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
