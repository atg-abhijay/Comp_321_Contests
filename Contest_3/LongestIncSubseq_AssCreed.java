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
                includedInLIS[i] = true;
            }

            int maximumValue = 0;

            for(int i = 1; i < lenSequence; i++) {
                boolean worksWithNone = true;
                for(int j = 0; j < i; j++) {
                    if(includedInLIS[j] && sequence[j] < sequence[i]) {
                        if(longestSeqTillHere[i] < longestSeqTillHere[j] + 1) {
                            longestSeqTillHere[i] = longestSeqTillHere[j] + 1;
                            includedInLIS[j] = true;
                            worksWithNone = false;
                        }
                        else {
                            includedInLIS[j] = false;
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

            for(int i = 0; i < lenSequence; i++) {
                if(includedInLIS[i]) {
                    System.out.print(i + " ");
                }
            }
        }
        sc.close();
    }
}