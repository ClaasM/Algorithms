/**
 * Performs iterative deepening A Star (A*) Algorithm to find the shortest path from a start to a target node..
 * Can be modified to handle graphs by keeping track of already visited nodes.
 *
 * @param tree      An adjacency-matrix-representation of the tree where (x,y) is the weight of the edge or 0 if there is no edge.
 * @param heuristic An estimation of distance from node x to y that is guaranteed to be lower than the actual distance. E.g. straight-line distance.
 * @param start      The node to start from.
 * @param goal      The node we're searching for.
 * @return number shortest distance to the goal node. Can be easily modified to return the path.
 */
const iterativeDeepeningAStar = function (tree, heuristic, start, goal) {
    var threshold = heuristic[start][goal];
    while (true) {
        console.log("Iteration with threshold: " + threshold);
        var distance = iterativeDeepeningAStarRec(tree, heuristic, start, goal, 0, threshold);
        if (distance === Number.MAX_VALUE) {
            // Node not found and no more nodes to visit
            return -1;
        } else if (distance < 0) {
            // if we found the node, the function returns the negative distance
            console.log("Found the node we're looking for!");
            return -distance;
        } else {
            // if it hasn't found the node, it returns the (positive) next-bigger threshold
            threshold = distance;
        }
    }
};

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
 * @return number shortest distance to the goal node. Can be easily modified to return the path.
 */
const iterativeDeepeningAStarRec = function (tree, heuristic, node, goal, distance, threshold) {
    console.log("Visiting Node " + node);

    if (node === goal) {
        // We have found the goal node we we're searching for
        return -distance;
    }

    var estimate = distance + heuristic[node][goal];
    if (estimate > threshold) {
        console.log("Breached threshold with heuristic: " + estimate);
        return estimate;
    }

    //...then, for all neighboring nodes....
    var min = Number.MAX_VALUE;
    for (var i = 0; i < tree[node].length; i++) {
        if (tree[node][i] !== 0) {
            var t = iterativeDeepeningAStarRec(tree, heuristic, i, goal, distance + tree[node][i], threshold);
            if (t < 0) {
                // Node found
                return t;
            } else if (t < min) {
                min = t;
            }
        }
    }
    return min;
};

module.exports = {iterativeDeepeningAStar};