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
            for(int i = 0; i < numPeople; i++) {
                vertices.add(new Vertex(i));
            }

            /**
             * initializations and adding
             * the edges, neighbours
             */
            ArrayList<Edge> edges = new ArrayList<Edge>();
            for(int i = 0; i < numConn; i++) {
                int firstVertex = sc.nextInt();
                int secondVertex = sc.nextInt();

                Vertex a = vertices.get(firstVertex);
                Vertex b = vertices.get(secondVertex);

                edges.add(new Edge(a, b));
                a.neighbours.add(b);
                b.neighbours.add(a);
            }

            boolean fine = true;
            for(Edge e: edges){
                Vertex firstVertex = e.firstVertex;
                Vertex secondVertex = e.secondVertex;

                /**
                 * removing an edge
                 */
                vertices.get(firstVertex.number).neighbours.remove(secondVertex);
                vertices.get(secondVertex.number).neighbours.remove(firstVertex);

                int stillConn = runBFS(vertices, firstVertex);
                /**
                 * if the number of vertices encountered
                 * upon removing an edge is not equal to
                 * the number of people then, the graph
                 * has become disconnected
                 */
                if(stillConn != numPeople) {
                    System.out.println("Yes");
                    fine = false;
                    break;
                }
                /**
                 * readding the edge before
                 * the next iteration starts
                 */
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

    /**
     * run BFS on the given graph and return
     * the number of vertices that were encountered
     */
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

        /**
         * setting visit status
         * to false before next
         * call to this function
         */
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