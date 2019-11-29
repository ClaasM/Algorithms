/**
 * Created by claas on 10//2019.
 * Used to perform the A-Star (A*) Algorithm to find the shortest path from a start to a target node.
 */

/**
 * Finds the shortest distance between two nodes using the A-star algorithm
 * @param graph an adjacency-matrix-representation of the graph where (x,y) is the weight of the edge or 0 if there is no edge.
 * @param heuristic an estimation of distance from node x to y that is guaranteed to be lower than the actual distance. E.g. straight-line distance
 * @param start the node to start from.
 * @param goal the node we're searching for
 * @return The shortest distance to the goal node. Can be easily modified to return the path.
 * */
const aStar = function (graph, heuristic, start, goal) {

    //This contains the distances from the start node to all other nodes
    var distances = [];
    //Initializing with a distance of "Infinity"
    for (var i = 0; i < graph.length; i++) distances[i] = Number.MAX_VALUE;
    //The distance from the start node to itself is of course 0
    distances[start] = 0;

    //This contains the priorities with which to visit the nodes, calculated using the heuristic.
    var priorities = [];
    //Initializing with a priority of "Infinity"
    for (var i = 0; i < graph.length; i++) priorities[i] = Number.MAX_VALUE;
    //start node has a priority equal to straight line distance to goal. It will be the first to be expanded.
    priorities[start] = heuristic[start][goal];

    //This contains whether a node was already visited
    var visited = [];

    //While there are nodes left to visit...
    while (true) {

        // ... find the node with the currently lowest priority...
        var lowestPriority = Number.MAX_VALUE;
        var lowestPriorityIndex = -1;
        for (var i = 0; i < priorities.length; i++) {
            //... by going through all nodes that haven't been visited yet
            if (priorities[i] < lowestPriority && !visited[i]) {
                lowestPriority = priorities[i];
                lowestPriorityIndex = i;
            }
        }

        if (lowestPriorityIndex === -1) {
            // There was no node not yet visited --> Node not found
            return -1;
        } else if (lowestPriorityIndex === goal) {
            // Goal node found
            // console.log("Goal node found!");
            return distances[lowestPriorityIndex];
        }

        // console.log("Visiting node " + lowestPriorityIndex + " with currently lowest priority of " + lowestPriority);

        //...then, for all neighboring nodes that haven't been visited yet....
        for (var i = 0; i < graph[lowestPriorityIndex].length; i++) {
            if (graph[lowestPriorityIndex][i] !== 0 && !visited[i]) {
                //...if the path over this edge is shorter...
                if (distances[lowestPriorityIndex] + graph[lowestPriorityIndex][i] < distances[i]) {
                    //...save this path as new shortest path
                    distances[i] = distances[lowestPriorityIndex] + graph[lowestPriorityIndex][i];
                    //...and set the priority with which we should continue with this node
                    priorities[i] = distances[i] + heuristic[i][goal];
                    // console.log("Updating distance of node " + i + " to " + distances[i] + " and priority to " + priorities[i]);
                }
            }
        }

        // Lastly, note that we are finished with this node.
        visited[lowestPriorityIndex] = true;
        //console.log("Visited nodes: " + visited);
        //console.log("Currently lowest distances: " + distances);

    }
};


module.exports = {aStar};