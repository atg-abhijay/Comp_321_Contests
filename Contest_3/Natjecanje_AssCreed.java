import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Natjecanje_AssCreed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTeams = sc.nextInt();
        int numDamaged = sc.nextInt();
        int numReserved = sc.nextInt();
        ArrayList<Integer> damaged = new ArrayList<Integer>();
        ArrayList<Integer> reserves = new ArrayList<Integer>();

        for(int i = 0; i < numDamaged; i++) {
            damaged.add(sc.nextInt());
        }

        for(int i = 0; i < numReserved; i++) {
            reserves.add(sc.nextInt());
        }

        Collections.sort(damaged);
        Collections.sort(reserves);

        int numFixed = 0;
        for(Integer damagedKayak: damaged) {
            for(Integer reserveKayak: reserves) {
                if(Math.abs(reserveKayak - damagedKayak) == 1) {
                    numFixed += 1;
                    reserves.remove(reserveKayak);
                    break;
                }
            }
            if(reserves.isEmpty()) {
                break;
            }
        }

        System.out.println(damaged.size() - numFixed);
        sc.close();
    }
}