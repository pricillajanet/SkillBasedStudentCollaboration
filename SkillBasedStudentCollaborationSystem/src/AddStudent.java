import java.sql.*;
import java.util.Scanner;

public class AddStudent {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Skills: ");
            String skills = sc.nextLine();

            System.out.print("Enter Interest: ");
            String interest = sc.nextLine();

            Connection con = DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            String query = "INSERT INTO students(name, skills, interest) VALUES('"
                    + name + "','" + skills + "','" + interest + "')";

            st.executeUpdate(query);

            System.out.println("Student Added Successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}