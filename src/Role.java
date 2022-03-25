import java.sql.*;
import java.util.Scanner;

public class Role {
    Scanner input = new Scanner(System.in);
     Connection connection;
     Statement statement;

    int id;
    String title;
    String description;

    public Role () {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }

    public Role(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public void menu () {
        System.out.println("Role Management Panel : ");
        System.out.println("\t 1. Add New Role");
        System.out.println("\t 2. Update Existing Role");
        System.out.println("\t 3. Delete Role");
        System.out.println("\t 4. View Available Roles");
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
            System.out.println("Please all required details. (Adding New Role)");
            System.out.print("\t Enter Title : ");
            this.title = input.next();
            
            System.out.print("\t Enter Description : ");
            this.description = input.next();

            statement = connection.createStatement();
            String sql = "INSERT INTO Roles (id, title, description)" + 
            "VALUES ("+ 0 +","+ this.id +", '" + this.title + "', '"+ this.description +"')";
            statement.executeUpdate(sql);
            System.out.println("Inserted record into the table roles...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void update () {
        try {
            System.out.println("Please all required details. (Update Existing Role)");
            System.out.print("\t Enter Role ID : ");
            this.id = Integer.parseInt(input.next());

            System.out.print("\t Enter Title : ");
            this.title = input.next();
            
            System.out.print("\t Enter Description : ");
            this.description = input.next();

            statement = connection.createStatement();
            String sql = 
                "UPDATE Roles" + 
                "SET 'title'=" + this.title + ", 'description'='" + 
                "WHERE id=" + this.id;
            statement.executeUpdate(sql);
            System.out.println("Updated a record into the table roles...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void delete () {
        try {
        System.out.println();
        System.out.println("Please all required details. (Delete Role)");
        System.out.print("\t Enter Role Id : ");
        this.id = Integer.parseInt(input.next());

        String sql = "DELETE FROM Roles WHERE id = " + this.id+"";
     statement.executeUpdate(sql);
     System.out.println("Deleted a record into the table roles...");
    } catch (SQLException e) {
        e.printStackTrace();
           System.exit(0);
        }
    }

    public void view () {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();

            String query = "SELECT id, title, description FROM Roles";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("All Roles");
            System.out.println("=========");
            while (resultSet.next()) {
                System.out.print("[ID]: " + resultSet.getInt("id"));
                System.out.print(", [TITLE]: " + resultSet.getInt("title"));
                System.out.println(", [DESCRIPTION]: " + resultSet.getString("description"));
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
