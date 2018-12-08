import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
public class ClassPicture_AssCreed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int n = sc.nextInt();
            PriorityQueue pQueue = new PriorityQueue<Person>();
            Person[] people = new Person[n];
            for(int i = 0; i < n; i++){
                String name = sc.next();
                pQueue.add(new Person(_name, connections));
            }
            ArrayList<Person[]> badConnections = new ArrayList<Person[]>();
            int m = sc.nextInt();
            for(int i = 0; i < m; i++){
                String p1 =
            }

        }
    }
}

class Person{
    String name;
    PriorityQueue<Person> pQueue = new PriorityQueue<Person>(new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.name.compareTo(p2.name);
        }
    });

    public Person(String _name){
        name = _name;
    }

    public void SetupConnections(Person[] connections, ArrayList<Person> enemies){
        for(Person p : connections){
            if(!enemies.contains(P)){
                pQueue.add(p);
            }
        }
    }
}