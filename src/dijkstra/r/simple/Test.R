source("src/dijkstra/r/simple/Dijkstra.R")


graph = matrix(c(
  0, 3, 1, 0, 0, 0,
  0, 0, 0, 2, 1, 0,
  0, 4, 0, 4, 0, 0,
  0, 0, 0, 0, 3, 2,
  0, 0, 0, 0, 0, 1,
  0, 0, 0, 0, 0, 0
), nrow=6, ncol=6, byrow=TRUE)

print(dijkstra(graph, 1))  # Should be [0, 3, 1, 5, 4, 5]

start = 1

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
