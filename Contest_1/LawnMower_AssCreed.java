import java.util.Scanner;
import java.util.Arrays;

public class LawnMower_AssCreed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dimensionX = 75;
        int dimensionY = 100;
        while(true) {
            int numX = sc.nextInt();
            int numY = sc.nextInt();
            double mowerWidth = sc.nextDouble();
            if(numX == 0 && numY == 0 && mowerWidth == 0.0) {
                break;
            }

            double[] cutSideToSide = new double[numX];
            for(int i = 0; i < numX; i++) {
                cutSideToSide[i] = sc.nextDouble();
            }

            double[] cutUpAndDown = new double[numY];
            for(int i = 0; i < numY; i++) {
                cutUpAndDown[i] = sc.nextDouble();
            }

            Arrays.sort(cutSideToSide);
            Arrays.sort(cutUpAndDown);

            boolean alongHorizontal = check(cutSideToSide, mowerWidth, dimensionX);
            boolean alongVertical = check(cutUpAndDown, mowerWidth, dimensionY);

            if(alongHorizontal && alongVertical) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    public static boolean check(double[] nums, double mowerWidth, int length) {
        double halfVal = mowerWidth/2;
        if(nums[0]-halfVal > 0) {
            return false;
        }

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] + halfVal < nums[i+1] - halfVal) {
                return false;
            }
        }

        if(nums[nums.length-1] + halfVal < length) {
            return false;
        }

        return true;
    }
}