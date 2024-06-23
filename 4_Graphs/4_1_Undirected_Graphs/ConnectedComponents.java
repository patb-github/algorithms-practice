import java.util.ArrayList;

/*
 * Computes connected components of a graph using depth-first search.
 */
public class ConnectedComponents {
    
    private final int V;
    private final int[] id;
    private int count;

    // preprocessing constructor
    public ConnectedComponents(Graph G) {
        V = G.V();
        count = 0;
        boolean[] marked = new boolean[V];
        id = new int[V];

        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) continue;
            else dfs(G, marked, i);
            count++;
        }
    }

    private void dfs(Graph G, boolean[] marked, int v) {
        if (marked[v]) return;

        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) dfs(G, marked, w);
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("the vertex " + v + " is out of bounds");
        }
    }

    // are v and w connected?
    public boolean connected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id[v] == id[w];
    }

    // returns number of connected components
    public int count() { return count; }

    // returns component id of v
    public int id(int v) {
        validateVertex(v);
        return id[v];
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

        ConnectedComponents cc = new ConnectedComponents(tiny);
        ArrayList<Integer>[] components = (ArrayList<Integer>[]) new ArrayList[cc.count()];

        for (int i = 0; i < components.length; i++) components[i] = new ArrayList<>();
        for (int v = 0; v < tiny.V(); v++) components[cc.id(v)].add(v);
        for (int i = 0; i < components.length; i++) {
            System.out.print(i + ": ");
            for (int v : components[i]) System.out.print(v + " ");
            System.out.println();
        }
    }
}
