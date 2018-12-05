import java.util.Scanner;

public class LongestIncSubseq_AssCreed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int lenSequence = sc.nextInt();
            int[] sequence = new int[lenSequence];
            for(int i = 0; i < lenSequence; i++) {
                sequence[i] = sc.nextInt();
            }

        }
        sc.close();
    }
}