package dijkstra.java.fast;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Used to perform the dijkstra Algorithm using adjacency lists.
 * For a faster implementation, see @see ../fast/Dijkstra.java (using adjacency Lists)
 */
public class Dijkstra {
    /**
     * Implementation of dijkstra using adjacency matrix & binary heap.
     * This returns an array containing the length of the shortest path from the start node to each other node.
     * It is only guaranteed to return correct results if there are no negative edges in the graph. Positive cycles are fine.
     * This has a runtime of O(|E| + |V|log|V|) (|V| = number of Nodes, |E| = number of Edges), for a simpler implementation see @see ../simple/Dijkstra.java (using adjacency matrices)

     * @param start the node to start from.
     */
    public static int[] dijkstra(int start) {
        //TODO implement using binary heap, reuse A Star code

        // Priority queue of pairs of (node index, distance to node + heuristic to goal)
        // Whereas the latter is used for prioritisation. Imagine the heuristic as being the "straight line distance"
        //PriorityQueue<int[]> priorities = new PriorityQueue<>(Comparator.comparingInt(node -> node[1]));

        // Starting with the start node.
        //priorities.add(new int[]{start, heuristic[start][goal]});

        // while (!priorities.isEmpty()) {
        //            // ... get the next node to visit ...
        //            int[] next = priorities.poll();

        // And then we need to somehow update the priorities

        return null;
    }
}
