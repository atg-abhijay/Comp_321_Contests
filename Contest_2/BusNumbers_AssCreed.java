import java.util.*;

public class BusNumbers_AssCreed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numBusStops = sc.nextInt();
        int[] busStops = new int[numBusStops];
        for(int i = 0; i < numBusStops; i++) {
            busStops[i] = sc.nextInt();
        }
        Arrays.sort(busStops);
        StringBuilder sb = new StringBuilder();
        sb.append(" " + busStops[0]);

        for(int i = 1; i < numBusStops; i++) {
            if(busStops[i] == busStops[i-1] + 1) {
                /**
                 * checking for multiple consecutive
                 * numbers and checking the edge case
                 */
                if(numBusStops > i+1 && busStops[i+1] == busStops[i] + 1) {
                    sb.append("-");
                    i += 2;
                    while(numBusStops > i && busStops[i] == busStops[i-1] + 1) {
                        i++;
                    }
                    i--;
                    sb.append(busStops[i]);
                }

                /**
                 * checking for only 2
                 * consecutive numbers
                 */
                else {
                    sb.append(" " + busStops[i]);
                }
            }

            /**
             * if the numbers are not consecutive,
             * so putting them separately
             */
            else {
                sb.append(" " + busStops[i]);
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }
}