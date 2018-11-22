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

            if(ans.equals(bigA) && !bigP.isProbablePrime(20)) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
        sc.close();
    }
}