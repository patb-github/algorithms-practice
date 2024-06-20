import java.util.ArrayList;
/*
 * Graph implmentation using an array of lists.
 * Parallel edges and self-loops are allowed.
 */
public class Graph {

    private final int V;
    private int E;
    private ArrayList<Integer>[] adjacencyList;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adjacencyList = (ArrayList<Integer>[]) new ArrayList[V];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public int V() { return this.V; }
    
    public int E() { return this.E; }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("the vertex " + v + " is out of bounds");
        }
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        // parallel edges and self-loops allowed
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        // no need to clone because we cannot modify the ArrayList through the Iterable interface
        return adjacencyList[v]; 
    }

    public int numAdjVertices(int v) {
        validateVertex(v);
        return adjacencyList[v].size(); 
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.V + " vertices, " + this.E + " edges\n");
        for (int i = 0; i < adjacencyList.length; i++) {
            output.append(i + ": ");
            for (Integer x : adjacencyList[i]) output.append(x + " ");
            output.append("\n");
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Graph tiny = new Graph(13);
        int[][] edges = {
            {0, 5},
            {4, 3},
            {0, 1},
            {9, 12},
            {6, 4},
            {5, 4},
            {0, 2},
            {11, 12},
            {9, 10},
            {0, 6},
            {7, 8},
            {9, 11},
            {5, 3}
        };

        for (int[] pair : edges) tiny.addEdge(pair[0], pair[1]);
        System.out.println(tiny);
    }
}