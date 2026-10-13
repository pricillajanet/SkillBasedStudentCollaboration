import java.sql.*;
import java.util.Scanner;

public class SearchStudent {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Skill to Search: ");
            String skill = sc.nextLine();

            Connection con = DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            String query = "SELECT * FROM students WHERE skills LIKE '%" + skill + "%'";

            ResultSet rs = st.executeQuery(query);

            System.out.println("\nMatching Students:");

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + " - " +
                                rs.getString("skills") + " - " +
                                rs.getString("interest")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}