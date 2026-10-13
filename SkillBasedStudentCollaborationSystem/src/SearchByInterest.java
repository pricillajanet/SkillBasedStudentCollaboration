import java.sql.*;
import java.util.Scanner;

public class SearchByInterest {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Interest to Search: ");
            String interest = sc.nextLine();

            Connection con = DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            String query = "SELECT * FROM students WHERE interest LIKE '%" + interest + "%'";

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