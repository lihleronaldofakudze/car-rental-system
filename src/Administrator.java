import java.sql.*;

public class Administrator {
    int id;
    int role;
    String name;
    String email;
    String address;
    String username;
    String password;

    public Administrator () {}

    public Administrator(int id, int role, String name, String email, String address) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public static boolean login (Connection connection, String username, String password) {
        return true;
    }

    public boolean add (Connection connection, int role, String name, String email, String address) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "INSERT INTO passengers (role, name, email, username, password)" + 
            "VALUES ('"+ role +"', '" + name + "', '"+username+"')";
            statement.executeUpdate(sql);
            System.out.println("Inserted records into the table administrator...");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update (int id, int role, String name, String email, String address) {
        return false;
    }

    public boolean delete (int id) {
        return false;
    }


}
