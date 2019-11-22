package iterative_deepening_a_star.java.simple;

/**
 * Created by claas on 7/17/2016.
 * Used to perform the Iterative Deepening A* Algorithm to find the shortest path from a start to a target node.
 */
public class IterativeDeepeningAStar {
    /**
     * Performs iterative deepening A Star (A*).
     * Can be modified to handle graphs by keeping track of already visited nodes.
     *
     * @param tree      An adjacency-matrix-representation of the tree where (x,y) is the weight of the edge or 0 if there is no edge.
     * @param heuristic An estimation of distance from node x to y that is guaranteed to be lower than the actual distance. E.g. straight-line distance.
     * @param start      The node to start from.
     * @param goal      The node we're searching for.
     * @return The shortest distance to the goal node. Can be easily modified to return the path.
     */
    public static double iterativeDeepeningAStar(int[][] tree, double[][] heuristic, int start, int goal) {
        double threshold = heuristic[start][goal];
        while (true) {
            System.out.printf("Iteration with threshold: %.2f\n", threshold);
            double distance = iterativeDeepeningAStar(tree, heuristic, start, goal, 0, threshold);
            if (distance == Double.MAX_VALUE) {
                // Node not found and no more nodes to visit
                return -1;
            } else if (distance < 0) {
                // if we found the node, the function returns the negative distance
                System.out.println("Found the node we're looking for!");
                return -distance;
            } else {
                // if it hasn't found the node, it returns the (positive) next-bigger threshold
                threshold = distance;
            }
        }
    }

    /**
     * Performs DFS up to a depth where a threshold is reached (as opposed to interative-deepening DFS which stops at a fixed depth).
     * Can be modified to handle graphs by keeping track of already visited nodes.
     *
     * @param tree      An adjacency-matrix-representation of the tree where (x,y) is the weight of the edge or 0 if there is no edge.
     * @param heuristic An estimation of distance from node x to y that is guaranteed to be lower than the actual distance. E.g. straight-line distance.
     * @param node      The node to continue from.
     * @param goal      The node we're searching for.
     * @param distance  Distance from start node to current node.
     * @param threshold Until which distance to search in this iteration.
     * @return The shortest distance to the goal node. Can be easily modified to return the path.
     */
    private static double iterativeDeepeningAStar(int[][] tree, double[][] heuristic, int node, int goal, double distance, double threshold) {
        System.out.println("Visiting Node " + node);

        if (node == goal) {
            // We have found the goal node we we're searching for
            return -distance;
        }

        double estimate = distance + heuristic[node][goal];
        if (estimate > threshold) {
            System.out.printf("Breached threshold with heuristic: %.2f\n", estimate);
            return estimate;
        }

        //...then, for all neighboring nodes....
        double min = Double.MAX_VALUE;
        for (int i = 0; i < tree[node].length; i++) {
            if (tree[node][i] != 0) {
                double t = iterativeDeepeningAStar(tree, heuristic, i, goal, distance + tree[node][i], threshold);
                if (t < 0) {
                    // Node found
                    return t;
                } else if (t < min) {
                    min = t;
                }
            }
        }
        return min;
    }
}