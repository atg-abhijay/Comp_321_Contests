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

            int maximumValue = 1;
            int indexPrevValid = 0;
            int indexPrevPrevValid = 0;

            for(int i = 1; i < lenSequence; i++) {
                int currentValue = sequence[i];
                if(currentValue > sequence[indexPrevValid]) {
                    longestSeqTillHere[i] = longestSeqTillHere[indexPrevValid] + 1;
                    maximumValue = longestSeqTillHere[i];
                    indexPrevPrevValid = indexPrevValid;
                    indexPrevValid = i;
                }
                else {
                    if(currentValue > sequence[indexPrevPrevValid]) {
                        includedInLIS[indexPrevValid] = false;
                        longestSeqTillHere[i] = longestSeqTillHere[indexPrevValid];
                        indexPrevValid = i;
                    }
                    else {
                        includedInLIS[i] = false;
                    }
                }
            }

            System.out.println(maximumValue);
            for(int i = 0; i < lenSequence; i++) {
                if(includedInLIS[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}