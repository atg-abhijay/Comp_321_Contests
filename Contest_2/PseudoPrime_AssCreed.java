import java.math.*;
import java.util.*;

public class PseudoPrime_AssCreed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int p = sc.nextInt();
            int a = sc.nextInt();

            if(p == 0 && a == 0) {
                break;
            }

            BigInteger bigP = new BigInteger("" + p);
            BigInteger bigA = new BigInteger("" + a);
            BigInteger ans = bigA.modPow(bigP, bigP);
            /**
             * if bigP is not prime with certainty 25%
             * and answer equal to A
             */
            if(ans.equals(bigA) && !bigP.isProbablePrime(25)) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
        sc.close();
    }
}