import java.sql.*;
import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // Classes in play
        Administrator administrator = new Administrator();
        Connection connection = DatabaseConnection.getConnection();

        // System In Progress
        System.out.println("Welcome back System Administration");
        System.out.println("1. Login");
        System.out.println("0. Exit");

        // Login Response
        System.out.print("Your response : ");
        int loginResponse = Integer.parseInt(input.next());

        if (loginResponse == 1) {
            System.out.print("Enter your username : ");
            String username = input.next();
            System.out.print("Enter your password : ");
            String password = input.next();
            boolean isLogged = Administrator.login(connection, username, password);

        } else if (loginResponse == 0) {
            System.out.println("Thank you, for using the system proper. GoodBye");
            System.exit(0);
        } else {
            System.exit(0);
        }

    }
}

// final String DB_URL = "jdbc:mysql://localhost:3306/java_test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
//         final String USERNAME = "root";
//         final String PASSWORD = "";

//         Connection conn = null;
//         Statement stmt = null;

//         try {
//             Class.forName("com.mysql.jdbc.Driver"); 
//             conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//             System.out.println("Connection database successfully...");
            
//             stmt = conn.createStatement();
//             String sql = "INSERT INTO users (username, email, phone)" + 
//             "VALUES ('Lihle', 'lihleronaldofakudze@gmail.com', '+26879499014')";
//             stmt.executeUpdate(sql);
//             System.out.println("Inserted records into the table...");
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         try{
//             if (stmt != null) 
//                 stmt.close();
//             if (conn != null)
//                 conn.close();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }