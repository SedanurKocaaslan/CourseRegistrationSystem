
package courseregistrationsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<Course>();

        int courseCount = 0;
        while (courseCount < 3) {
            System.out.print("How many courses to create (at least 3): ");
            courseCount = scanner.nextInt();
            scanner.nextLine();
        }

        for (int i = 0; i < courseCount; i++) {
            System.out.print("Enter name for course " + (i + 1) + ": ");
            String cName = scanner.nextLine();
            System.out.print("Enter capacity for " + cName + ": ");
            int cap = scanner.nextInt();
            scanner.nextLine();
            courses.add(new Course(cName, cap));
        }

        System.out.println("\nAvailable Courses:");
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }

        while (true) {
            System.out.println("\n1. Register Student");
            System.out.println("2. View All Courses");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter course name to register: ");
                String targetCourse = scanner.nextLine();

                Course selectedCourse = null;
                for (Course c : courses) {
                    if (c.courseName.equalsIgnoreCase(targetCourse)) {
                        selectedCourse = c;
                        break;
                    }
                }

                if (selectedCourse == null) {
                    System.out.println("No course found with that name.");
                    continue;
                }

                if (selectedCourse.enrolledStudents.size() >= selectedCourse.capacity) {
                    System.out.println("This course is full. Registration failed.");
                    continue;
                }

                System.out.print("Enter Student ID: ");
                String sId = scanner.nextLine();
                System.out.print("Enter Student Name: ");
                String sName = scanner.nextLine();

                boolean isDuplicate = false;
                for (Student s : selectedCourse.enrolledStudents) {
                    if (s.studentID.equals(sId)) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (isDuplicate) {
                    System.out.println("This student is already registered for this course.");
                } else {
                    selectedCourse.enrolledStudents.add(new Student(sId, sName));
                    System.out.println("Registration successful.");
                }

            } else if (choice == 2) {
                System.out.println("\n--- All Courses ---");
                for (Course c : courses) {
                    c.displayCourseInfo();
                }
            } else if (choice == 3) {
                break;
            }
        }

        scanner.close();
    }
}
