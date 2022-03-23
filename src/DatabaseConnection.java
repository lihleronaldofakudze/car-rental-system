import java.sql.*;

public class DatabaseConnection {
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/java_test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static Connection connection = null;
    static {
        try{
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection database successfully...");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection () {
        return connection;
    }
}
