import java.util.Scanner;
public class PrimeReduction_AssCreed {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 4) {
                break;
            }
            primeReduction(n , 0);
        }
        sc.close();
    }

	public static void primeReduction(int p , int counter) {
		counter++;
		if (isPrime(p)) {
			System.out.println(p + " " + counter);
			return;
	    }

		int sum = 0;
		int div = 2;

		while(true) {
			if (p % div == 0) {
				p = p/div;
				sum += div;
				if (isPrime(p)) {
					sum += p;
					break;
				}
				div = 1;
			}
			div++;
		}
		primeReduction(sum, counter);
	}

    public static boolean isPrime(int n) {
		if (n == 2) {
            return true;
        }

		if (n % 2 == 0) {
            return false;
        }

		int bound = (int) Math.sqrt(n);
		for (int i = 3; i <= bound; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

		return true;
	}
}