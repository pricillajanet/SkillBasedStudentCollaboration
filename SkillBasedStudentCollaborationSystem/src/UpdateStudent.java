import java.sql.*;
import java.util.Scanner;

public class UpdateStudent {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Student ID to Update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Skills: ");
            String skills = sc.nextLine();

            System.out.print("Enter New Interest: ");
            String interest = sc.nextLine();

            Connection con = DatabaseConnection.getConnection();

            String query = "UPDATE students SET name=?, skills=?, interest=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, skills);
            ps.setString(3, interest);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully!");
            } else {
                System.out.println("Student ID not found!");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}