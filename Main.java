import java.util.Scanner;

class Student {
    // Data members
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    // Parameterized Constructor
    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Method to calculate course fee (Rs. 1500 per credit)
    public double calculateFee() {
        return courseCredits * 1500.0;
    }

    // Method to check eligibility (marks >= 50)
    public boolean checkEligibility() {
        return marks >= 50;
    }

    // Method to calculate scholarship based on marks
    public double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85) {
            return 0.20 * fee; // 20% scholarship
        } else if (marks >= 70) {
            return 0.10 * fee; // 10% scholarship
        } else {
            return 0.0; // No scholarship
        }
    }

    // Method to calculate final fee after scholarship deduction
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Method to display student and course details
    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Marks              : " + marks);
        System.out.println("Course Name        : " + courseName);
        System.out.println("Course Credits     : " + courseCredits);
        System.out.println("Eligibility Status : " + (checkEligibility() ? "Eligible" : "Not Eligible"));
        System.out.println("Total Fee          : Rs. " + calculateFee());
        System.out.println("Scholarship        : Rs. " + calculateScholarship());
        System.out.println("Final Fee          : Rs. " + calculateFinalFee());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input student and course details
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String roll = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine(); // consume leftover newline

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        // Create object using parameterized constructor
        Student student = new Student(name, roll, marks, course, credits);

        // First check eligibility before displaying fee/scholarship details
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nStudent " + name + " is not eligible for course registration due to insufficient marks (Marks < 50).");
        }

        sc.close();
    }
}