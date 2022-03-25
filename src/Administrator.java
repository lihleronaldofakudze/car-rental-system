import java.sql.*;
import java.util.Scanner;

public class Administrator {
    Scanner input = new Scanner(System.in);
     Connection connection;
     Statement statement;

    int id;
    int roleId;
    String name;
    String email;
    String address;
    String username;
    String password;

    public Administrator () {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }

    public Administrator(int id, int role, String name, String email, String address) {
        this.id = id;
        this.roleId = role;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public static boolean login (String username, String password) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT username, password FROM Administrators";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                if (resultSet.getString("username") == username && resultSet.getString("password") == password) {
                    break;
                }
             }
             return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void menu () {
        System.out.println("Administrators Management Panel : ");
        System.out.println("\t 1. Add New Administrator");
        System.out.println("\t 2. Update Existing Administrator");
        System.out.println("\t 3. Delete Administrator");
        System.out.println("\t 4. View Available Administrators");
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
            System.out.println("Please all required details. (Adding New Administrator)");
            System.out.print("\t Enter Role ID : ");
            this.roleId = Integer.parseInt(input.next());

            System.out.print("\t Enter Name : ");
            this.name = input.next();
            
            System.out.print("\t Enter Address : ");
            this.address = input.next();

            System.out.print("\t Enter Email : ");
            this.email = input.next();

            System.out.print("\t Enter Username : ");
            this.username = input.next();

            System.out.print("\t Enter Password : ");
            this.password = input.next();

            statement = connection.createStatement();
            String sql = "INSERT INTO Administrators (id, role_id, name, email, address, username, password)" + 
            "VALUES ("+ 0 +","+ this.roleId +", '" + this.name + "', '"+ this.email +"','"+ this.address +"','"+ this.username +"', '"+ this.password +"')";
            statement.executeUpdate(sql);
            System.out.println("Inserted record into the table administrators...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void update () {
        try {
            System.out.println("Please all required details. (Update Existing Administrator)");
            System.out.print("\t Enter Administrator ID : ");
            this.id = Integer.parseInt(input.next());

            System.out.print("\t Enter Role ID : ");
            this.roleId = Integer.parseInt(input.next());

            System.out.print("\t Enter Name : ");
            this.name = input.next();
            
            System.out.print("\t Enter Address : ");
            this.address = input.next();

            System.out.print("\t Enter Email : ");
            this.email = input.next();

            System.out.print("\t Enter Username : ");
            this.username = input.next();

            System.out.print("\t Enter Password : ");
            this.password = input.next();

            statement = connection.createStatement();
            String sql = 
                "UPDATE Administrators" + 
                "SET 'role_id'=" + this.roleId + ", 'name'='" + this.name + "', 'email'='" + this.email + "', 'address'='" + this.address + "', 'username'='" + this.username + "', 'password'='" + this.password +"'"+ 
                "WHERE id=" + this.id;
            statement.executeUpdate(sql);
            System.out.println("Updated a record into the table administrators...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void delete () {
        try {
        System.out.println();
        System.out.println("Please all required details. (Delete Administrator)");
        System.out.print("\t Enter Administrator Id : ");
        this.id = Integer.parseInt(input.next());

        String sql = "DELETE FROM Administrators WHERE id = " + this.id+"";
     statement.executeUpdate(sql);
     System.out.println("Deleted a record into the table administrators...");
    } catch (SQLException e) {
        e.printStackTrace();
           System.exit(0);
        }
    }

    public void view () {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();

            String query = "SELECT id, role_id, name, email, address, username, password FROM Administrators";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("All Administrators");
            System.out.println("==================");
            while (resultSet.next()) {
                System.out.print("[ID]: " + resultSet.getInt("id"));
                System.out.print(", [ROLE ID]: " + resultSet.getInt("role_id"));
                System.out.print(", [NAME]: " + resultSet.getString("name"));
                System.out.print(", [EMAIL]: " + resultSet.getString("email"));
                System.out.print(", [ADDRESS]: " + resultSet.getString("address"));
                System.out.print(", [USERNAME]: " + resultSet.getString("username"));
                System.out.println(", [PASSWORD]: " + resultSet.getString("password"));
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
