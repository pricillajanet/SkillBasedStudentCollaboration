import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/skill_collaboration",
                    "root",
                    "janeT@2005"
            );

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}