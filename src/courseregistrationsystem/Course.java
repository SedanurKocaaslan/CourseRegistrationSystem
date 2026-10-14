
package courseregistrationsystem;
import java.util.ArrayList;

public class Course {
    String courseName;
    int capacity;
    ArrayList<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<Student>();
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + " | Capacity: " + enrolledStudents.size() + "/" + capacity);
        System.out.print("Enrolled Students: ");
        if (enrolledStudents.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < enrolledStudents.size(); i++) {
                System.out.print(enrolledStudents.get(i).name);
                if (i < enrolledStudents.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
