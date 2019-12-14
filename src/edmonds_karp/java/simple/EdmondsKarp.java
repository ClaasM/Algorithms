package edmonds_karp.java.simple;

import java.util.*;

/**
 * Used to perform the Edmonds-Karp Algorithm using adjacency matrices.
 * For a faster implementation, see @see ../fast/EdmondsKarp.java (using adjacency Lists)
 */
public class EdmondsKarp {
    /**
     * Implementation of Edmonds-Karp using adjacency matrix.
     * It uses O(|V|^3) time, where |V| is the number of nodes in the network.
     * @param graph an adjacency-matrix-representation of the flow graph where (x,y) is the capacity of the edge or 0 if there is no edge.
     * @param from  the starting node from which to calculate the flow
     * @param to    the ending node to which to calculate the flow
     * @return the flow from node "to" to node "from"
     */
    public static int edmondsKarp(int[][] graph, int from, int to) {


        int flow = 0;
        int[][] flowNetwork = new int[graph.length][graph.length];

        while (true) {

            //Using a modified version of BFS to find an augmenting path. @see ../../../BFS/java/simple/BFS.java for a more detailed explanation of BFS.

            //Instead of a "visited"-array, we use an array containing the previously visited node or -1 if it hasn't been visited.
            int[] previous = new int[graph.length];
            Arrays.fill(previous, -1);
            previous[from] = -1;

            Queue<Integer> queue = new PriorityQueue<>();
            queue.add(from);
            while (!queue.isEmpty()) {
                int node = queue.remove();
                for (int i = 0; i < graph[node].length; i++) {
                    //The node has not been visited and there is a flow in the opposite direction or the flow is smaller then the direct flow.
                    if (previous[i] == -1 && (flowNetwork[i][node] > 0 || flowNetwork[node][i] < graph[node][i])) {
                        previous[i] = node;
                        queue.add(i);
                    }
                }

            }

            if (previous[to] == -1) {
                //There are no more augmenting paths -> we are done
                break;
            }

            //Find the bottleneck from node "from" to node "to"
            int bottleneckCapacity = Integer.MAX_VALUE;
            //Iterate the augmenting path
            for (int i = to, prev = previous[i]; prev >= 0; i = prev, prev = previous[i]) {

                if (flowNetwork[i][prev] > 0) {
                    // If there is positive flow it's just the current flow on that edge
                    bottleneckCapacity = Math.min(bottleneckCapacity, flowNetwork[i][prev]);
                } else {
                    // If not, its the capacity of the edge minus the "anti-flow"
                    bottleneckCapacity = Math.min(bottleneckCapacity, graph[prev][i] - flowNetwork[prev][i]);
                }
            }

            //Iterate the augmenting path again to update the network
            for (int i = to, prev = previous[i]; prev >= 0; i = prev, prev = previous[i]) {
                if (flowNetwork[i][prev] > 0) {
                    //We have anti flow
                    flowNetwork[i][prev] -= bottleneckCapacity;
                } else {
                    //We have normal flow
                    flowNetwork[prev][i] += bottleneckCapacity;
                }
            }

            //We found the bottleneck flow, add it to the total flow
            flow += bottleneckCapacity;
        }
        return flow;
    }
}
