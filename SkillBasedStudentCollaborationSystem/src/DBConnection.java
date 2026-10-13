import java.sql.*;

public class DBConnection {
    public static void main(String[] args) {
        try {

            Connection con = DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getString("skills") + " "
                        + rs.getString("interest"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}