import java.util.Scanner;

public class RestaurantOrders_AssCreed {
    static int[] multiplicities = new int[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numItems = sc.nextInt();
        int[][] menu = new int[numItems][2];
        for(int i = 0; i < numItems; i++) {
            menu[i][0] = sc.nextInt();
        }
        int numOrdersPlaced = sc.nextInt();
        int[][] orderPrices = new int[numOrdersPlaced][2];
        for(int i = 0; i < numOrdersPlaced; i++) {
            orderPrices[i][0] = sc.nextInt();
            orderPrices[i][1] = solve(menu, orderPrices[i][0], 0, 0);
        }

        for(int i = 0; i < numOrdersPlaced; i++) {
            if(orderPrices[i][1] == 0) {
                System.out.println("Impossible");
            }
            else if(orderPrices[i][1] < 0) {
                System.out.println("Ambiguous");
            }
            else{
                for(int j = 0; j < multiplicities.length; j++){
                    for(int k = 0; k < multiplicities[j]; k++){
                        System.out.print(menu[multiplicities[j]] + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static int solve(int[][] menu, int order, int current, int totalCombo) {
        if(current == order) {

            int same = 0;
            int zeros = 0;
            for(int i = 0; i < menu.length; i++){
                if(multiplicities[i] == menu[i][0]){
                    same++;
                }
                if(multiplicities[i] == 0){
                    zeros++;
                }
            }
            if(same != multiplicities.length && zeros == multiplicities.length){
                return 0;
            }
            if(zeros != multiplicities.length){
                return -1;
            }


            for(int i = 0; i < menu.length; i++) {
                multiplicities[i] = menu[i][0];
            }
            return 1;
        }

        if(current < order) {
            int childCount = 0;
            for(int i = 0; i < menu.length; i++) {
                int[][] newMenu = new int[menu.length][2];
                // copy array
                for(int j = 0; j < menu.length; j++) {
                    for(int k = 0; k < 2; k++) {
                        newMenu[j][k] = menu[j][k];
                    }
                }
                newMenu[i][1] = newMenu[i][1] + 1;
                int returnVal = solve(newMenu, order, comboFromMenu(newMenu), 0);
                if(returnVal != -1) {
                    childCount += returnVal;
                }
                else {
                    return returnVal;
                }

            }
            return childCount;
        }

        return 0;
    }

    public static int comboFromMenu(int[][] menu) {
        int sum = 0;
        for(int i = 0; i < menu.length; i++) {
            sum += menu[i][0] * menu[i][1];
        }

        return sum;
    }
}