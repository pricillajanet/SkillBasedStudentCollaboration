import java.sql.*;
import java.util.Scanner;

public class DeleteStudent {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();

            Connection con = DatabaseConnection.getConnection();

            String query = "DELETE FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student ID not found!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}