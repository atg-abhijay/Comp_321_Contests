import java.util.*;

public class AboveAverage_AssCreed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for(int i = 0; i < numTestCases; i++) {
            int numStudents = sc.nextInt();
            int[] marks = new int[numStudents];
            int totalMarks = 0;
            for(int j = 0; j < numStudents; j++) {
                marks[j] = sc.nextInt();
                totalMarks += marks[j];
            }
            double averageMarks = totalMarks/numStudents;
            double higherThanAverage = 0;
            for(int j = 0; j < numStudents; j++) {
                if(marks[j] > averageMarks) {
                    higherThanAverage += 1;
                }
            }
            higherThanAverage *= 100;
            System.out.printf("%.3f", higherThanAverage/numStudents);
            System.out.println("%");
        }
        sc.close();
    }
}