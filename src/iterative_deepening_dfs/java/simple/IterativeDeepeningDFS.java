package iterative_deepening_dfs.java.simple;

/**
 * Used to perform the Iterative Deepening Depth-First Search (DFS) Algorithm to find the shortest path from a start to a target node.
 */
public class IterativeDeepeningDFS {
    private static boolean bottomReached = false; // Variable to keep track if we have reached the bottom of the tree

    /**
     * Implementation of iterative deepening DFS (depth-first search).
     * Given a start node, this returns the node in the tree below the start node with the target value (or null if it doesn't exist)
     * Runs in O(n), where n is the number of nodes in the tree, or O(b^d), where b is the branching factor and d is the depth.
     * @param start  the node to start the search from
     * @param target the value to search for
     * @return The node containing the target value or null if it doesn't exist.
     */
    public static Node iterativeDeepeningDFS(Node start, int target) {
        // Start by doing DFS with a depth of 1, keep doubling depth until we reach the "bottom" of the tree or find the node we're searching for
        int depth = 1;
        while (!bottomReached) {
            bottomReached = true; // One of the "end nodes" of the search with this depth has to still have children and set this to false again
            Node result = iterativeDeepeningDFS(start, target, 0, depth);
            if (result != null) {
                // We've found the goal node while doing DFS with this max depth
                return result;
            }

            // We haven't found the goal node, but there are still deeper nodes to search through
            depth *= 2;
            System.out.println("Increasing depth to " + depth);
        }

        // Bottom reached is true.
        // We haven't found the node and there were no more nodes that still have children to explore at a higher depth.
        return null;
    }

    private static Node iterativeDeepeningDFS(Node node, int target, int currentDepth, int maxDepth) {
        System.out.println("Visiting Node " + node.value);
        if (node.value == target) {
            // We have found the goal node we we're searching for
            System.out.println("Found the node we're looking for!");
            return node;
        }

        if (currentDepth == maxDepth) {
            System.out.println("Current maximum depth reached, returning...");
            // We have reached the end for this depth...
            if (node.children.length > 0) {
                //...but we have not yet reached the bottom of the tree
                bottomReached = false;
            }
            return null;
        }

        // Recurse with all children
        for (int i = 0; i < node.children.length; i++) {
            Node result = iterativeDeepeningDFS(node.children[i], target, currentDepth + 1, maxDepth);
            if (result != null) {
                // We've found the goal node while going down that child
                return result;
            }
        }

        // We've gone through all children and not found the goal node
        return null;
    }
}

// used to store a tree datastructure
class Node {
    Node[] children;
    int value;
}