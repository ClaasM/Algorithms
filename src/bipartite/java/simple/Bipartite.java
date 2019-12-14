package bipartite.java.simple;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Used to find out if a graph represented using adjacency matrices is bipartite.
 * For a faster implementation, see @see ../fast/Bipartite.java (using adjacency Lists)
 */
public class Bipartite {
    /**
     * Function that returns whether a given graph is bipartite or not.
     * This has a runtime of O(|V|^2) (|V| = number of Nodes), for a faster implementation see @see ../fast/Bipartite.java (using adjacency Lists)
     * @param graph an adjacency-matrix-representation of the graph where (x,y) is true if the the there is an edge between nodes x and y.
     * @return whether the graph is bipartite or not
     */
    public static boolean bipartite(boolean[][] graph) {
        //A Queue to manage the nodes that have yet to be visited
        Queue<Integer> queue = new PriorityQueue<>();
        //Adding the node to start from
        queue.add(0);
        //A boolean array indicating whether we have already visited a node
        boolean[] visited = new boolean[graph.length];
        //(The start node is already visited)
        visited[0] = true;
        //A boolean Array indicating whether a node is colored.
        boolean[] colored = new boolean[graph.length];
        //While there are nodes left to visit...
        while(!queue.isEmpty()) {
            int node = queue.remove();
            //...for all neighboring nodes that haven't been visited yet....
            for (int i = 1; i < graph[node].length; i++) {
                if(graph[node][i] && !visited[i]){
                    //Visit it and add it to the queue
                    visited[i] = true;
                    queue.add(i);
                    //Color it in the opposite color
                    colored[i] = !colored[node];
                } else if (graph[node][i] && visited[i] && colored[i] == colored[node]){
                    // Two adjacent nodes have the same color -> we found a odd length cycle -> the graph is not bipartite
                    return false;
                }
            }

        }
        //There is no odd-length cycle in the graph -> the graph is bipartite
        return true;
    }
}
