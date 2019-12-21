dijkstra <- function(graph, start){
  #' Implementation of dijkstra using adjacency matrix.
  #' This returns an array containing the length of the shortest path from the start node to each other node.
  #' It is only guaranteed to return correct results if there are no negative edges in the graph. Positive cycles are fine.
  #' This has a runtime of O(|V|^2) (|V| = number of Nodes), for a faster implementation see @see ../fast/Dijkstra.java (using adjacency lists)
  #' @param graph an adjacency-matrix-representation of the graph where (x,y) is the weight of the edge or 0 if there is no edge.
  #' @param start the node to start from.
  #' @return an array containing the shortest distances from the given start node to each other node
  
  
  # This contains the distances from the start node to all other nodes
  distances = rep(Inf, nrow(graph))
  
  # This contains whether a node was already visited
  visited = rep(FALSE, nrow(graph))
  
  # The distance from the start node to itself is of course 0
  distances[start] = 0
  
  # While there are nodes left to visit...
  repeat{
    
    # ... find the node with the currently shortest distance from the start node...
    shortest_distance = Inf
    shortest_index = -1
    for(i in seq_along(distances)) {
      # ... by going through all nodes that haven't been visited yet
      if(distances[i] < shortest_distance && !visited[i]){
        shortest_distance = distances[i]
        shortest_index = i
      }
    }
    
    cat("Visiting node ", shortest_index, " with current distance ", shortest_distance, "\n")
    
    if(shortest_index == -1){
      # There was no node not yet visited --> We are done
      return (distances)
    }
    # ...then, for all neighboring nodes that haven't been visited yet....
    for(i in seq_along(graph[shortest_index,])) {
      # ...if the path over this edge is shorter...
      if(graph[shortest_index,i] != 0 && distances[i] > distances[shortest_index] + graph[shortest_index,i]){
        # ...Save this path as new shortest path.
        distances[i] = distances[shortest_index] + graph[shortest_index,i]
        cat("Updating distance of node ", i, " to ", distances[i], "\n")
      }
      # Lastly, note that we are finished with this node.
      visited[shortest_index] = TRUE
      cat("Visited nodes: ", visited, "\n")
      cat("Currently lowest distances: ", distances, "\n")
    }
  }
}

