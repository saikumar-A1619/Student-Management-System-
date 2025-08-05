import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<Student>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.println("Enter Student ID: ");
        int id = sc.nextInt();

        System.out.println("Enter Student Name: ");
        String name = sc.next();

        System.out.println("Enter Student Marks: ");
        int marks = sc.nextInt();

        Student student = new Student(id, name, marks);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("--- Student Records ---");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void updateStudent() {
        System.out.println("Enter Student ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {

                System.out.println("Enter Student Name: ");
                students.get(i).setName(sc.next());
                System.out.println("Enter Student Marks: ");
                students.get(i).setMarks(sc.nextInt());
                System.out.println("Student updated successfully.");
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public static void deleteStudentById() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student with " + id + " deleted successfully.");
                return;
            }
        }

        System.out.println("Student with ID " + id + " not found.");
    }

    public static void main(String[] args) {


        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudentById();
                    break;

                case 5:
                    System.exit(0);

            }
        }

    }
}
