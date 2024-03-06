package javav.mvc.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectClass {
    private static final String URL = "jdbc:mariadb://localhost:3306/SchimbValutar";
    private static final String USER = "root_ex";
    private static final String PASSWORD = "root_ex";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            
            Class.forName("org.mariadb.jdbc.Driver");


            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
