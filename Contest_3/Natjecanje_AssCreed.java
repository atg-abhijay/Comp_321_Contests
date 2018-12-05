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

        while(!damaged.isEmpty()) {
            Integer damagedKayak = damaged.get(0);
            boolean entered = false;
            while(!reserves.isEmpty()) {
                Integer reserveKayak = reserves.get(0);
                if(Math.abs(reserveKayak - damagedKayak) == 1) {
                    damaged.remove(0);
                    reserves.remove(0);
                    entered = true;
                    break;
                }
            }

            if(!entered) {
                break;
            }
        }

        System.out.println(damaged.size());
        sc.close();
    }
}