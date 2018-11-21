import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Person implements Comparator<Person> {
    int number;
    int money;
    int deadline;

    public Person() {

    }

    public Person(int n, int m, int d) {
        this.number = n;
        this.money = m;
        this.deadline = d;
    }

    @Override
    public int compare(Person p1, Person p2) {
        if(p1.deadline > p2.deadline) {
			return -1;
		}
		else if (p1.deadline < p2.deadline) {
			return 1;
		}
		else {
			if (p1.money < p2.money) {
				return 1;
			}
			else if (p1.money > p2.money) {
				return -1;
			}
			else {
				return 0;
			}
		}
    }
}

public class Bank_AssCreed {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<Person>();
        Scanner sc = new Scanner(System.in);
        int numPeople = sc.nextInt();
        int lastDeadline = sc.nextInt();
        for(int i = 0; i < numPeople; i++) {
            Person p = new Person(i, sc.nextInt(), sc.nextInt()+1);
            people.add(p);
        }
        sc.close();

        // Collections.sort(people, new Person());
        int[] depositPlan = new int[numPeople];

        int[] shiftedDeadlines = new int[numPeople];
		for(int i = 0; i < numPeople; i++) {
			shiftedDeadlines[i] = people.get(i).deadline;
        }

        int currentDeadline = people.get(0).deadline;
		while(currentDeadline > 0) {
			Person highestMoneyPerson = new Person();
			int highestMoney = 0;
			/**
			 * keeps track of the index of the
			 * assignment with the highest money
			 * amongst the sorted assignments.
			 */
			int indexWithHighest = 0;
			for(int i = 0; i < numPeople; i++) {
				/**
				 * iterate over all those assignments
				 * whose deadline (dl) matches the current
				 * dl. amongst those, find the one with the
				 * highest money and store its details in the
				 * different variables instantiated above.
				 */
				if(shiftedDeadlines[i] == currentDeadline) {
					if(people.get(i).money > highestMoney) {
						highestMoneyPerson = people.get(i);
						highestMoney = people.get(i).money;
						indexWithHighest = i;
					}
				}
			}

			/**
			 * after finding the assignment with the highest
			 * money amongst those with the same current dl,
			 * put it in the time slot starting from the LAST
			 * time slot available, i.e. the 1st assignment
			 * found with this procedure will be done in the
			 * last time slot, the 2nd one will be done in the second
			 * last time slot and so on.
			 */
			depositPlan[highestMoneyPerson.number] = currentDeadline;
			/**
			 * for those assignments which possessed the current dl
			 * (except the highest money assignment), decrease their
			 * deadlines by one. since they weren't chosen in this
			 * iteration, they may be chosen in the next, so we decrease
			 * their deadline so that they may be considered in the
			 * computation of the next iteration.
			 */
			for(int i = 0; i < numPeople; i++) {
				if(shiftedDeadlines[i] == currentDeadline) {
					if(i != indexWithHighest) {
						shiftedDeadlines[i] -=1;
					}
				}
			}
			/**
			 * decrement the deadline and progress
			 * towards the earlier assignments.
			 */
			currentDeadline -= 1;
        }

        int maxMoney = 0;
		for(int i = 0; i < depositPlan.length; i++) {
            if(depositPlan[i] != 0) {
                maxMoney += people.get(i).money;
            }
        }

        System.out.println(maxMoney);
    }
}