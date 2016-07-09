package dfs.java.simple;

/**
 * Created by ClaasM on 7/9/2016.
 * Used to perform Depth-First-Search (DFS) using adjacency matrizes.
 * For a faster implementation, see @see ../fast/DFS.java (using adjacency Lists)
 */
public class DFS {
    /**
     * Recursive implementation of Depth-First-Search using adjacency matrix.
     * This returns nothing (yet), it is meant to be a template for whatever you want to do with it,
     * e.g. finding connected components in a graph.
     * This has a runtime of O(n^2), for a faster implementation see @see ../fast/DFS.java (using adjacency Lists)
     * @param graph an adjacency-matrix-representation of the graph where (x,y) is true if the the there is an edge between nodes x and y.
     * @param current the node to start from.
     * @param visited an array denoting whether a node has been visited or not.
     */
    public static void DFS(boolean[][] graph, int current, boolean[] visited){
        //Label the current node as visited
            visited[current] = true;
        //For each node...
        for (int i = 0; i < graph[current].length; i++) {
            //...if there is an edge between the node and current node and the node has not yet been visited...
            if(graph[current][i] && !visited[i]){
                //...recursively call DFS with i being the next node.
                DFS(graph,i,visited);
            }

        }

    }
}