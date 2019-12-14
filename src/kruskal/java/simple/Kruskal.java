package kruskal.java.simple;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Used to perform the Kruskal Algorithm using adjacency matrices.
 * For a faster implementation, see @see ../fast/Kruskal.java (using adjacency Lists)
 */
public class Kruskal {
    /**
     * Implementation of Kruskal using adjacency lists.
     * This returns an array containing the parent node for every node in the MST of the graph and -1 for the root.
     * This has a runtime of O(|E|*log(|E|)) (|E| = number of Edges), because the edges have to be sorted.
     * If the edges are already sorted, the runtime is reduced to O(|E|* log(|V|)) (|V| = number of Nodes) using a Union-Find data structure.
     */
    public static int[] kruskal() {
        //TODO implement
        // Sort all edges by weight
        // Add the smallest edge that doesn't result in a cycle until all nodes are connected.


        return null;

    }
}
