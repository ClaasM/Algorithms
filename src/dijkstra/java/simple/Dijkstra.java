package dijkstra.java.simple;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by claas on 7/11/2016.
 * Used to perform the dijkstra Algorithm using adjacency matrices.
 * For a faster implementation, see @see ../fast/dijkstra.java (using adjacency Lists)
 */
public class Dijkstra {
    /**
     * Implementation of dijkstra using adjacency matrix.
     * This returns an array containing the length of the shortest path from the start node to each other node.
     * It is only guaranteed to return correct results if there are no negative edges in the graph. Positive cycles are fine. //TODO check if this is true
     * This has a runtime of O(|V|^2) (|V| = number of Nodes), for a faster implementation see @see ../fast/dijkstra.java (using adjacency Lists)
     * @param graph an adjacency-matrix-representation of the graph where (x,y) is the weight of the edge or 0 if there is no edge.
     * @param start the node to start from.
     */
    public static int[] dijkstra(int[][] graph, int start) {

        //This contains the distances from the start node to all other nodes
        int[] distance = new int[graph.length];
        //Initializing with a distance of "Infinity"
        Arrays.fill(distance, Integer.MAX_VALUE);

        //The distance from the start node to itself is of course 0
        distance[start] = 0;

        //A Queue to manage the nodes that have yet to be visited
        Queue<Integer> queue = new PriorityQueue<>();

        //While there are nodes left to visit...
        while (!queue.isEmpty()) {
            int node = queue.remove();
            //...for all neighboring nodes that haven't been visited yet....
            for (int i = 0; i < graph[node].length; i++) {
                //...if the path over this edge is shorter...
                if (graph[node][i] != 0 && distance[i] > distance[node] + graph[node][i]) {
                    //...Save this path as new shortest path.
                    distance[i] = distance[node] + graph[node][i];
                }
            }
        }
        return distance;

    }
}
