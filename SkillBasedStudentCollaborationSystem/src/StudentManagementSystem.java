import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT COLLABORATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search By Skill");
            System.out.println("4. Search By Interest");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    AddStudent.main(null);
                    break;

                case 2:
                    DBConnection.main(null);
                    break;

                case 3:
                    SearchStudent.main(null);
                    break;

                case 4:
                    SearchByInterest.main(null);
                    break;

                case 5:
                    UpdateStudent.main(null);
                    break;

                case 6:
                    DeleteStudent.main(null);
                    break;

                case 7:
                    System.out.println("Thank You!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}