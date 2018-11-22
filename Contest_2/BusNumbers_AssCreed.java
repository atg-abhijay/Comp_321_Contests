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
        String s = " " + busStops[0];

        for(int i = 1; i < numBusStops; i++) {
            if(busStops[i] == busStops[i-1] + 1) {
                if(numBusStops > i+1 && busStops[i+1] == busStops[i] + 1) {
                    s += "-";
                    i += 2;
                    while(numBusStops > i && busStops[i] == busStops[i-1] + 1) {
                        i++;
                    }
                    i--;
                    s += busStops[i];
                }

                else {
                    s += " " + busStops[i];
                }
            }

            else {
                s += " " + busStops[i];
            }
        }
        System.out.println(s);
        sc.close();
    }
}