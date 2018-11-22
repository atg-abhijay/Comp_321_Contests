import java.util.*;

public class BirthdayParty_AssCreed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int numPeople = sc.nextInt();
            int numConn = sc.nextInt();
            /**
             * end of test cases
             */
            if(numPeople == 0 && numConn == 0) {
                break;
            }

            ArrayList<Vertex> vertices = new ArrayList<Vertex>();
            ArrayList<Edge> edges = new ArrayList<Edge>();
            for(int i = 0; i < numConn; i++) {
                int firstVertex = sc.nextInt();
                int secondVertex = sc.nextInt();

                Vertex a = new Vertex(firstVertex);
                Vertex b = new Vertex(secondVertex);

                if(!checkVertexExists(vertices, firstVertex)) {
                    vertices.add(a);
                }
                else {
                    a = vertices.get(firstVertex);
                }

                if(!checkVertexExists(vertices, secondVertex)) {
                    vertices.add(b);
                }
                else{
                    b = vertices.get(secondVertex);
                }

                edges.add(new Edge(a, b));
                a.neighbours.add(b);
                b.neighbours.add(a);
            }

            boolean fine = true;
            for(Edge e: edges){
                Vertex firstVertex = e.firstVertex;
                Vertex secondVertex = e.secondVertex;
                vertices.get(firstVertex.number).neighbours.remove(secondVertex);
                vertices.get(secondVertex.number).neighbours.remove(firstVertex);
                int stillConn = runBFS(vertices, firstVertex);
                if(stillConn != numPeople) {
                    System.out.println("Yes");
                    fine = false;
                    break;
                }
                vertices.get(firstVertex.number).neighbours.add(secondVertex);
                vertices.get(secondVertex.number).neighbours.add(firstVertex);
            }
            if(fine) {
                System.out.println("No");
            }
        }
        sc.close();
    }

    public static boolean checkVertexExists(ArrayList<Vertex> vertices, int newVertex) {
        for(Vertex v: vertices) {
            if(v.number == newVertex) {
                return true;
            }
        }
        return false;
    }

    public static int runBFS(ArrayList<Vertex> vertices, Vertex sourceVertex) {
        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(sourceVertex);
        sourceVertex.visited = true;
        int count = 1;
        while(!q.isEmpty()) {
            Vertex vertex = q.peek();
            for(Vertex endVertex: vertex.neighbours) {
                if(!endVertex.visited) {
                    q.add(endVertex);
                    endVertex.visited = true;
                    count += 1;
                }
            }
            q.poll();
        }
        for(Vertex v: vertices) {
            v.visited = false;
        }
        return count;
    }

}

class Edge {
    public Vertex firstVertex;
    public Vertex secondVertex;

    Edge(Vertex a, Vertex b) {
        this.firstVertex = a;
        this.secondVertex = b;
    }
}

class Vertex {
    public Integer number;
    public boolean visited;
    public ArrayList<Vertex> neighbours;

    Vertex(Integer n) {
        this.number = n;
        this.visited = false;
        this.neighbours = new ArrayList<Vertex>();
    }
}