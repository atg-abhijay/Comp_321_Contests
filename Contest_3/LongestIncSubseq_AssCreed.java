import java.util.Scanner;

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
            }

            int startIndex = 0;
            int otherIndex = 0;
            int maximumValue = 0;

            for(int i = 1; i < lenSequence; i++) {
                for(int j = 0; j < i; j++) {
                    if(sequence[j] < sequence[i]) {
                        if(longestSeqTillHere[i] < longestSeqTillHere[j] + 1) {
                            longestSeqTillHere[i] = longestSeqTillHere[j] + 1;
                            includedInLIS[j] = true;
                            includedInLIS[i] = true;
                        }
                        else {
                            includedInLIS[i] = false;
                            includedInLIS[j] = false;
                        }
                    }
                }
            }

            for(int i = 0; i < lenSequence; i++) {
                if(maximumValue < longestSeqTillHere[i]) {
                    maximumValue = longestSeqTillHere[i];
                }
            }
            System.out.println(maximumValue);

            for(int i = 0; i < lenSequence; i++) {
                if(includedInLIS[i]) {
                    System.out.print(i + " ");
                }
            }
        }
        sc.close();
    }
}