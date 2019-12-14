/**
 * Implementation of Breadth-First-Search (BFS) using adjacency matrix.
 * This returns nothing (yet), it is meant to be a template for whatever you want to do with it,
 * e.g. finding the shortest path in a unweighted graph.
 * This has a runtime of O(|V|^2) (|V| = number of Nodes), for a faster implementation see @see ../fast/BFS.java (using adjacency Lists)
 *
 * @param graph an adjacency-matrix-representation of the graph where (x,y) is true if the the there is an edge between nodes x and y.
 * @param start the node to start from.
 * @return Array array containing the shortest distances from the given start node to each other node
 */
const bfs = function (graph, start) {
    //A Queue to manage the nodes that have yet to be visited
    var queue = [];
    //Adding the node to start from
    queue.push(start);
    //A boolean array indicating whether we have already visited a node
    var visited = [];
    //(The start node is already visited)
    visited[start] = true;
    // Keeping the distances (might not be necessary depending on your use case)
    var distances = []; // No need to set initial values since every node is visted exactly once
    //(the distance to the start node is 0)
    distances[start] = 0;
    //While there are nodes left to visit...
    while (queue.length > 0) {
        console.log("Visited nodes: " + visited);
        console.log("Distances: " + distances);
        var node = queue.shift();
        console.log("Removing node " + node + " from the queue...");
        //...for all neighboring nodes that haven't been visited yet....
        for (var i = 1; i < graph[node].length; i++) {
            if (graph[node][i] && !visited[i]) {
                // Do whatever you want to do with the node here.
                // Visit it, set the distance and add it to the queue
                visited[i] = true;
                distances[i] = distances[node] + 1;
                queue.push(i);
                console.log("Visiting node " + i + ", setting its distance to " + distances[i] + " and adding it to the queue");

            }
        }
    }
    console.log("No more nodes in the queue. Distances: " + distances);
    return distances;
};

module.exports = {bfs};