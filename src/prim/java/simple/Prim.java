package prim.java.simple;

import java.util.Arrays;

import static javafx.scene.input.KeyCode.V;

/**
 * Created by claas on 7/11/2016.
 * Used to perform the Prim Algorithm using adjacency matrices.
 * For a faster implementation, see @see ../fast/Prim.java (using adjacency Lists)
 */
public class Prim {
    /**
     * Implementation of Prim using adjacency matrix.
     * This returns an array containing the parent node for every node in the MST of the graph.
     * This has a runtime of O(|V|^2) (|V| = number of Nodes), for a faster implementation see @see ../fast/Prim.java (using adjacency Lists)
     * @param graph an adjacency-matrix-representation of the graph where (x,y) is the weight of the edge or 0 if there is no edge.
     */
    public static int[] prim(int[][] graph) {

        // Stores the parent of each node in the minimum spanning tree
        int parent[] = new int[graph.length];
        // The first node is the root
        parent[0] = -1;
        // Boolean Array denoting whether a node is already part of the MST
        boolean inSet[] = new boolean[graph.length];

        // Int Array containing the weight of the edge with which a node is connected to the MST TODO maybe it's better to not use it
        int key[] = new int[graph.length];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        //For each Node...
        for (int i = 0; i <= graph.length; i++) {
            //...Find the smallest edge that is not yet part of the MST...
            int minimum = Integer.MAX_VALUE;
            int minimum_index = -1;
            for (int j = 0; j < graph.length; j++)
                if (!inSet[j] && key[j] < minimum) {
                    minimum = key[j];
                    minimum_index = j;
                }

            // ...add it to the MST...
            inSet[minimum_index] = true;

            for (int j = 0; j < graph.length; j++) {
                if (!inSet[j] && graph[minimum_index][j] < key[j]) {
                    parent[j] = minimum_index;
                    key[j] = graph[minimum_index][j];
                }
            }
        }

        return parent;
    }
}
