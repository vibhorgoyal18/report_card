package practice.report_card;

import java.util.Scanner;

public class ReportCard {

    public static void main(String[] args) {
        String subject1 = "English";
        String subject2 = "Maths";
        String subject3 = "Science";

        for (int counter = 0; counter < 3; counter++) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter name of student: ");
            String studentName = scanner.nextLine();

            System.out.println("Enter marks in English: ");
            int marksInEnglish = scanner.nextInt();
            System.out.println("Enter marks in Maths: ");
            int marksInMaths = scanner.nextInt();
            System.out.println("Enter marks in Science: ");
            int marksInScience = scanner.nextInt();
            String gradesInEnglish = calculateGrade(marksInEnglish);
            String gradesInMaths = calculateGrade(marksInMaths);
            String gradesInScience = calculateGrade(marksInScience);

            int totalMarks = marksInEnglish + marksInMaths + marksInScience;
            String gradeInTotal = calculateTotalGrades(gradesInEnglish, gradesInMaths, gradesInScience, totalMarks);

            System.out.println(studentName);
            System.out.println("Subject        Marks    Grades");
            System.out.println(subject1 + "        " + marksInEnglish + "       " + gradesInEnglish);
            System.out.println(subject2 + "          " + marksInMaths + "       " + gradesInMaths);
            System.out.println(subject3 + "        " + marksInScience + "       " + gradesInScience);
            System.out.println("Total Marks" + "    " + totalMarks + "      " + gradeInTotal);

            String result = gradeInTotal.equals("F") ? "Fail" : "Pass";
            System.out.println("Result: " + result);
        }
    }

    public static String calculateGrade(int marks) {
        String grades = "";
        if (marks >= 90 && marks <= 100) {
            grades = "A+";
        } else if (marks >= 80 && marks <= 89) {
            grades = "A";
        } else if (marks >= 70 && marks <= 79) {
            grades = "B+";
        } else if (marks >= 60 && marks <= 69) {
            grades = "B";
        } else if (marks >= 50 && marks <= 59) {
            grades = "C+";
        } else if (marks >= 40 && marks <= 49) {
            grades = "C";
        } else if (marks <= 39) {
            grades = "F";
        }
        return grades;
    }

    public static String calculateTotalGrades(String gradeInEnglish, String gradeInMaths, String gradeInScience, int totalMarks) {
        if (gradeInEnglish.equals("F") || gradeInMaths.equals("F") || gradeInScience.equals("F")) {
            return "F";
        } else {
            int percentage = (totalMarks * 100) / 300;
            return calculateGrade(percentage);
        }
    }
}
