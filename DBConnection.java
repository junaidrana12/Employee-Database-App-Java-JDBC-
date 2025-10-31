package Task7.EmployeeDatabaseApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
               static String user ="root";
               static String pass ="rana@123";
               static String url = "jdbc:mysql://localhost:3306/employee_db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

}
