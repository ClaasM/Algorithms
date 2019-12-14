var bottomReached = false; // Variable to keep track if we have reached the bottom of the tree

/**
 * Implementation of iterative deepening DFS (depth-first search) Algorithm to find the shortest path from a start to a target node..
 * Given a start node, this returns the node in the tree below the start node with the target value (or null if it doesn't exist)
 * Runs in O(n), where n is the number of nodes in the tree, or O(b^d), where b is the branching factor and d is the depth.
 * @param start  the node to start the search from
 * @param target the value to search for
 * @return The node containing the target value or null if it doesn't exist.
 */
const iterativeDeepeningDFS = function (start, target) {
    // Start by doing DFS with a depth of 1, keep doubling depth until we reach the "bottom" of the tree or find the node we're searching for
    var depth = 1;
    while (!bottomReached) {
        bottomReached = true; // One of the "end nodes" of the search with this depth has to still have children and set this to false again
        var result = iterativeDeepeningDFSRec(start, target, 0, depth);
        if (result != null) {
            // We've found the goal node while doing DFS with this max depth
            return result;
        }

        // We haven't found the goal node, but there are still deeper nodes to search through
        depth *= 2;
        console.log("Increasing depth to " + depth);
    }

    // Bottom reached is true.
    // We haven't found the node and there were no more nodes that still have children to explore at a higher depth.
    return null;
};

const iterativeDeepeningDFSRec = function (node, target, currentDepth, maxDepth) {
    console.log("Visiting Node " + node.value);
    if (node.value === target) {
        // We have found the goal node we we're searching for
        console.log("Found the node we're looking for!");
        return node;
    }

    if (currentDepth === maxDepth) {
        console.log("Current maximum depth reached, returning...");
        // We have reached the end for this depth...
        if (node.children.length > 0) {
            //...but we have not yet reached the bottom of the tree
            bottomReached = false;
        }
        return null;
    }

    // Recurse with all children
    for (var i = 0; i < node.children.length; i++) {
        var result = iterativeDeepeningDFSRec(node.children[i], target, currentDepth + 1, maxDepth);
        if (result != null) {
            // We've found the goal node while going down that child
            return result;
        }
    }

    // We've gone through all children and not found the goal node
    return null;
};

module.exports = {iterativeDeepeningDFS};