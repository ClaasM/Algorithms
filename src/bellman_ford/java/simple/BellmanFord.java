package bellman_ford.java.simple;

import java.util.Arrays;

/**
 * Used to perform the Bellman Ford Algorithm using adjacency matrices.
 * For a faster implementation, see @see ../fast/bellmanFord.java (using adjacency Lists)
 */
public class BellmanFord {
    /**
     * Implementation of Bellman-Ford using adjacency matrix.
     * This returns an array containing the length of the shortest path from the start node to each other node.
     * It is only guaranteed to return correct results if there are no negative cycles in the graph. Negative edges or positive cycles are fine.
     * This has a runtime of O(|V|^3) (|V| = number of Nodes), for a faster implementation see @see ../fast/bellmanFord.java (using adjacency Lists)
     * @param graph an adjacency-matrix-representation of the graph where (x,y) is the weight of the edge or 0 if there is no edge.
     * @param start the node to start from.
     */
    public static int[] bellmanFord(int[][] graph, int start){

        //TODO split this into a version that returns the shortest distances to all nodes and one that returns the shortest path to one node (aka. predecessor[]), (also for Dijkstra)

        //This is used to save the shortest path (the int in distance[i] is the predecessor of i)
        int[] predecessor = new int[graph.length];
        //Initializing with "no predecessor"
        Arrays.fill(predecessor, -1);
        //This contains the distances from the start node to all other nodes
        int[] distance = new int[graph.length];
        //Initializing with a distance of "Infinity"
        Arrays.fill(distance, Integer.MAX_VALUE);

        //The distance from the start node to itself is of course 0
        distance[start] = 0;

        //Relax n-1 times since the shortest path in a graph with no negative cycles crosses at most n-1 nodes
        for (int i = 1; i < distance.length - 1; i++) {
            //For each edge...
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].length; k++) {
                    //...if the path over this edge is shorter...
                    if (distance[k] != 0 && distance[k] > distance[j] + graph[j][k]) {
                        //...Save this path as new shortest path.
                        distance[k] = distance[j] + graph[j][k];
                        predecessor[k] = j;
                    }
                }

            }
        }
        return distance;

    }
}
