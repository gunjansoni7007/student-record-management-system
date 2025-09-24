import java.util.ArrayList;
import java.util.Scanner;

// Student Class
class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

// Main Class
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("✅ Student Added Successfully!");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No student records found.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();
                System.out.print("Enter New Marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setMarks(marks);

                System.out.println("✅ Student Updated Successfully!");
                return;
            }
        }
        System.out.println("⚠️ Student with ID " + id + " not found.");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("✅ Student Deleted Successfully!");
                return;
            }
        }
        System.out.println("⚠️ Student with ID " + id + " not found.");
    }

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: 
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}
