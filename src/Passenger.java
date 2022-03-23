import java.sql.*;

public class Passenger {
    int id;
    String name;
    int phoneNumber;
    String address;
    
    String email;


    public Passenger () {

    }

    public Passenger(int id, String name, int phoneNumber, String address, String email){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public boolean add (Connection connection, String name, int phoneNumber, String address, String email) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO passengers (username, email, phone)" + 
            "VALUES ('Lihle', 'lihleronaldofakudze@gmail.com', '+26879499014')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update (int id, String name, int phoneNumber, String address, String email) {
        return false;
    }

    public boolean delete (int id) {
        return false;
    }
}
