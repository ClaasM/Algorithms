package floyd_warshall.java.simple;

import java.util.Arrays;

/**
 * Used to perform the Floyd-Warshall Algorithm using adjacency matrices.
 * For a faster implementation, see @see ../fast/FloydWarshall.java (using adjacency Lists)
 */
public class FloydWarshall {
    /**
     * Implementation of Floyd-Warshall using adjacency matrix.
     * This returns an array containing the length of the shortest path from the each node to each other node.
     * It is only guaranteed to return correct results if there are no negative cycles in the graph. Positive cycles or negative edges are fine.
     * This has a runtime of O(|V|^3) (|V| = number of Nodes), for a faster implementation see @see ../fast/FloydWarshall.java (using adjacency Lists)
     * @param graph an adjacency-matrix-representation of the graph where (x,y) is the weight of the edge or 0 if there is no edge.
     * @return an array containing the distances from all nodes to all nodes.
     */
    public static int[][] floydWarshall(int[][] graph) {

        // Array to store the shortest distances from all nodes to all nodes, initialized with infinity
        int[][] distance = new int[graph.length][graph.length];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        //The distance of a node to itself is always 0.
        for (int i = 0; i < graph.length; i++) {
            distance[i][i] = 0;
        }

        //For all edges the distance between its nodes is equal to the weight of the edge.
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if(graph[i][j] != 0){
                    distance[i][j] = graph[i][j];
                }
            }
        }

        //For each node
        for (int i = 0; i < graph.length; i++) {
            //For each pair of intermediary edges
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph.length; k++) {
                    //If the distance using the two edges is smaller that the distance using the current way
                    if(distance[j][k] > distance[j][i] + distance[i][k]){
                        //..set the new way as the new shortest distance.
                        distance[j][k] = distance[j][i] + distance[i][k];
                    }
                }

            }
        }

        return distance;
    }
}
