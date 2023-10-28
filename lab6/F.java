package lab6;

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class F {
    public static class Student {
        String firstName;
        String lastName;
        double gpa;

        public Student(String firstName, String lastName, double gpa) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gpa = gpa;
        }
    }

    public static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            // First, compare by GPA in descending order
            if (student1.gpa != student2.gpa) {
                return Double.compare(student1.gpa, student2.gpa);
            }

            // If GPA is equal, compare by last name
            int lastNameComparison = student1.lastName.compareTo(student2.lastName);
            if (lastNameComparison != 0) {
                return lastNameComparison;
            }

            // If last names are equal, compare by first name
            return student1.firstName.compareTo(student2.firstName);
        }
    }

    public static void main(String[] args) throws IOException {
        DecimalFormat decimalFormat = new DecimalFormat("0.000");

        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            String firstName = info[1];
            String lastName = info[0];
            int m = Integer.parseInt(info[2]);

            double totalCredits = 0;
            double totalGPA = 0;

            for (int j = 0; j < m; j++) {
                String mark = info[3 + 2 * j];
                int credits = Integer.parseInt(info[4 + 2 * j]);
                totalCredits += credits;
                totalGPA += calculateGPA(mark) * credits;
            }

            double gpa = totalGPA / totalCredits;
            students.add(new Student(firstName, lastName, gpa));
        }

        Collections.sort(students, new StudentComparator());

        for (Student student : students) {
            bw.write(student.lastName + " " + student.firstName + " " + decimalFormat.format(student.gpa));
            bw.newLine();
        }
        bw.close();
    }

    private static double calculateGPA(String mark) {
        switch (mark) {
            case "A+":
                return 4.00;
            case "A":
                return 3.75;
            case "B+":
                return 3.50;
            case "B":
                return 3.00;
            case "C+":
                return 2.50;
            case "C":
                return 2.00;
            case "D+":
                return 1.50;
            case "D":
                return 1.00;
            case "F":
                return 0.00;
            default:
                return 0.00; // Handle unexpected marks as F (0.00)
        }
    }
}
