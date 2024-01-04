import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        // Variables to store student's marks and grades
        int totalSubjects = 0;
        double totalMarks = 0;
        double averagePercentage = 0;
        String studentGrade;
        Scanner scan = new Scanner(System.in);

        System.out.println("Student Grade Calculator\n");

        // Get the number of subjects from the user
        System.out.print("Enter Number Of Subjects: ");
        totalSubjects = scan.nextInt();

        // Create an array to store marks for each subject
        double marksInEachSubject[] = new double[totalSubjects];

        // Take marks for each subject from the user
        System.out.println();
        for (int i = 0; i < totalSubjects; i++) {
            System.out.print("Enter Subject " + (i + 1) + " marks: ");
            marksInEachSubject[i] = scan.nextDouble();
            totalMarks += marksInEachSubject[i];
        }
        // Calculate the average percentage
        System.out.println();
        averagePercentage = totalMarks / totalSubjects;

        // Determine the grade based on the average percentage
        if (averagePercentage >= 95.0 && averagePercentage <= 100.0) {
            studentGrade = "A+";
        } else if (averagePercentage >= 85.0 && averagePercentage <= 94.0) {
            studentGrade = "A";
        } else if (averagePercentage >= 75.0 && averagePercentage <= 84.0) {
            studentGrade = "B";
        } else if (averagePercentage >= 55.0 && averagePercentage <= 74.0) {
            studentGrade = "C";
        } else if (averagePercentage >= 35.0 && averagePercentage <= 54.0) {
            studentGrade = "D";
        } else {
            studentGrade = "F";
        }

        // Display results
        System.out.printf("Total Marks Obtained: %.2f Out Of %d\n", totalMarks, (totalSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + studentGrade);

        scan.close();
    }
}
