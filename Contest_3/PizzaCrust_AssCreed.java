import java.util.Scanner;

public class PizzaCrust_AssCreed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        int cutout = sc.nextInt();

        double totalArea = Math.PI*radius*radius;
        double cutoutArea = Math.PI*(radius-cutout)*(radius-cutout);
        System.out.println((cutoutArea/totalArea)*100);
        sc.close();
    }
}