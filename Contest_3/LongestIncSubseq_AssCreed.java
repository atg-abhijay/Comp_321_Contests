import java.util.Scanner;
import java.util.Stack;

public class LongestIncSubseq_AssCreed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int lenSequence = sc.nextInt();
            int[] sequence = new int[lenSequence];
            int[] longestSeqTillHere = new int[lenSequence];
            boolean[] includedInLIS = new boolean[lenSequence];
            for(int i = 0; i < lenSequence; i++) {
                sequence[i] = sc.nextInt();
                longestSeqTillHere[i] = 1;
                includedInLIS[i] = true;
            }

            int maximumValue = 0;

            for(int i = 1; i < lenSequence; i++) {
                boolean worksWithNone = true;
                for(int j = 0; j < i; j++) {
                    if(includedInLIS[j] && sequence[j] < sequence[i]) {
                        if(longestSeqTillHere[i] < longestSeqTillHere[j] + 1) {
                            longestSeqTillHere[i] = longestSeqTillHere[j] + 1;
                            worksWithNone = false;
                        }
                    }
                }

                if(worksWithNone) {
                    includedInLIS[i] = false;
                }
            }

            for(int i = 0; i < lenSequence; i++) {
                if(maximumValue < longestSeqTillHere[i]) {
                    maximumValue = longestSeqTillHere[i];
                }
            }
            System.out.println(maximumValue);

            Stack<Integer> validNums = new Stack<Integer>();
            for(int i = lenSequence-1; i > -1; i--) {
                if(longestSeqTillHere[i] == maximumValue) {
                    validNums.push(i);
                    maximumValue--;
                }
            }

            while(!validNums.isEmpty()) {
                System.out.print(validNums.pop() + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}