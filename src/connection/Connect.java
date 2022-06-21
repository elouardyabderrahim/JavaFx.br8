package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static String dbURL = "jdbc:postgresql://localhost:5432/condidat";
	private static String username = "postgres";
	private static String password = "abderrahimelouardy1997";
	 
	public static Connection getconnect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connected successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
