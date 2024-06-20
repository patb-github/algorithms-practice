/*
 * Parallel edge detection. Devise a linear-time algorithm to count the parallel edges in a graph.
 * Hint: maintain a boolean array of the neighbors of a vertex, and reuse this array by only reinitializing the entries as needed.
 * 
 * Definition: Two edges are <em>parallel</em> if they connect the same pair of vertices.
 */

public class Creative_32 {
    public static int countParallelEdges(Graph G) {
        int parallelEdges = 0;
        boolean[] checkedNeighbors = new boolean[G.V()]; 

        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (checkedNeighbors[w]) parallelEdges++;
                else checkedNeighbors[w] = true;
            }
            // reset checkedNeighbors to all false
            for (int w : G.adj(v)) checkedNeighbors[w] = false;
        }

        return parallelEdges / 2;
    }

    /*
     * Run-time Analysis:
     * The algorithm takes proportional to V + 2E. 
     * It creates an array of length V, then iterates through all the edges to check
     * for parallel edges, while also going through the edges again to reset the neighbor array.
     */

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
            {0, 5},
            {7, 8},
            {9, 11},
            {5, 3},
            {0, 5}
        };

        for (int[] pair : edges) tiny.addEdge(pair[0], pair[1]);
        System.out.println(countParallelEdges(tiny));
    }
}
