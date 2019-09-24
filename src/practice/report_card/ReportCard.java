package practice.report_card;

import java.util.Scanner;

public class ReportCard {

    public static void main(String[] args) {
        String[] subjects = {"English", "Maths", "Science"};
        int numberOfStudents = 3;
        String[] studentNames = new String[numberOfStudents];
        int[] marksInEnglish = new int[numberOfStudents];
        int[] marksInMaths = new int[numberOfStudents];
        int[] marksInScience = new int[numberOfStudents];
        Scanner scanner = new Scanner(System.in);

        for (int index = 0; index < numberOfStudents; index++) {
            System.out.print("\nEnter the name of the student: ");
            studentNames[index] = scanner.next();
            System.out.print("\nEnter marks in English: ");
            marksInEnglish[index] = scanner.nextInt();
            System.out.print("\nEnter marks in Maths: ");
            marksInMaths[index] = scanner.nextInt();
            System.out.print("\nEnter marks in Science: ");
            marksInScience[index] = scanner.nextInt();
        }

        for (int index = 0; index < numberOfStudents; index++) {
            String gradesInEnglish = calculateGrade(marksInEnglish[index]);
            String gradesInMaths = calculateGrade(marksInMaths[index]);
            String gradesInScience = calculateGrade(marksInScience[index]);

            int totalMarks = marksInEnglish[index] + marksInMaths[index] + marksInScience[index];
            String gradesInTotal = calculateTotalGrades(gradesInEnglish, gradesInMaths, gradesInScience, totalMarks);

            System.out.println(studentNames[index]);
            System.out.println("Subject" + calculateSpaces("Subject") + "Marks" + calculateSpaces("Marks") + "Grades");

            System.out.println(subjects[0] +
                    calculateSpaces(subjects[0]) +
                    marksInEnglish[index] +
                    calculateSpaces(String.valueOf(marksInEnglish[index])) +
                    gradesInEnglish);
            System.out.println(subjects[1] +
                    calculateSpaces(subjects[1]) +
                    marksInMaths[index] +
                    calculateSpaces(String.valueOf(marksInMaths[index])) +
                    gradesInMaths);
            System.out.println(subjects[2] +
                    calculateSpaces(subjects[2]) +
                    marksInScience[index] +
                    calculateSpaces(String.valueOf(marksInScience[index])) +
                    gradesInScience);
            System.out.println("Total Marks" +
                    calculateSpaces("Total Marks") +
                    totalMarks + calculateSpaces(String.valueOf(totalMarks)) +
                    gradesInTotal);

            String result = gradesInTotal.equals("F") ? "Fail" : "Pass";
            System.out.println("Result: " + result);
        }

    }

    private static String calculateGrade(int marks) {
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

    private static String calculateTotalGrades(String gradeInEnglish, String gradeInMaths, String gradeInScience, int totalMarks) {
        if (gradeInEnglish.equals("F") || gradeInMaths.equals("F") || gradeInScience.equals("F")) {
            return "F";
        } else {
            int percentage = (totalMarks * 100) / 300;
            return calculateGrade(percentage);
        }
    }

    private static String calculateSpaces(String text) {
        String totalSpaces = "            ";
        totalSpaces = totalSpaces.substring(text.length() - 1, 11);
        return totalSpaces;
    }
}
