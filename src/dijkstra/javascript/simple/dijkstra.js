/**
 * Implementation of Dijkstra Algorithm using adjacency matrix.
 * This returns an array containing the length of the shortest path from the start node to each other node.
 * It is only guaranteed to return correct results if there are no negative edges in the graph. Positive cycles are fine.
 * This has a runtime of O(|V|^2) (|V| = number of Nodes), for a faster implementation see @see ../fast/Dijkstra.java (using adjacency lists)
 *
 * @param graph an adjacency-matrix-representation of the graph where (x,y) is the weight of the edge or 0 if there is no edge.
 * @param start the node to start from.
 * @return an array containing the shortest distances from the given start node to each other node
 */
const dijkstra = function (graph, start) {

    //This contains the distances from the start node to all other nodes
    var distances = [];
    //Initializing with a distance of "Infinity"
    for (var i = 0; i < graph.length; i++) distances[i] = Number.MAX_VALUE;
    //The distance from the start node to itself is of course 0
    distances[start] = 0;

    //This contains whether a node was already visited
    var visited = [];

    //While there are nodes left to visit...
    while (true) {
        // ... find the node with the currently shortest distance from the start node...
        var shortestDistance = Number.MAX_VALUE;
        var shortestIndex = -1;
        for (var i = 0; i < graph.length; i++) {
            //... by going through all nodes that haven't been visited yet
            if (distances[i] < shortestDistance && !visited[i]) {
                shortestDistance = distances[i];
                shortestIndex = i;
            }
        }

        console.log("Visiting node " + shortestDistance + " with current distance " + shortestDistance);

        if (shortestIndex === -1) {
            // There was no node not yet visited --> We are done
            return distances;
        }

        //...then, for all neighboring nodes....
        for (var i = 0; i < graph[shortestIndex].length; i++) {
            //...if the path over this edge is shorter...
            if (graph[shortestIndex][i] !== 0 && distances[i] > distances[shortestIndex] + graph[shortestIndex][i]) {
                //...Save this path as new shortest path.
                distances[i] = distances[shortestIndex] + graph[shortestIndex][i];
                console.log("Updating distance of node " + i + " to " + distances[i]);
            }
        }
        // Lastly, note that we are finished with this node.
        visited[shortestIndex] = true;
        console.log("Visited nodes: " + visited);
        console.log("Currently lowest distances: " + distances);

    }
};

module.exports = {dijkstra};