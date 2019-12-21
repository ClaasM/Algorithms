bfs <- function(graph, start){
    #' Implementation of Breadth-First-Search (BFS) using adjacency matrix.
    #' This returns nothing (yet), it is meant to be a template for whatever you want to do with it,
    #' e.g. finding the shortest path in a unweighted graph.
    #' This has a runtime of O(|V|^2) (|V| = number of Nodes), for a faster implementation see @see ../fast/BFS.java (using adjacency Lists)
    #' @param graph an adjacency-matrix-representation of the graph where (x,y) is TRUE if the the there is an edge between nodes x and y.
    #' @param start the node to start from.
    #' @return Array array containing the shortest distances from the given start node to each other node

  # A Queue to manage the nodes that have yet to be visited, intialized with the start node
  queue = c(start)
  # A boolean array indicating whether we have already visited a node
  visited = rep(FALSE, nrow(graph))
  # (The start node is already visited)
  visited[start] = TRUE
  # Keeping the distances (might not be necessary depending on your use case)
  distances = rep(Inf, nrow(graph))  # Technically no need to set initial values since every node is visted exactly once
  # (the distance to the start node is 0)
  distances[start] = 0
  # While there are nodes left to visit...
  while(length(queue) > 0) {
    cat("Visited nodes: ", visited, "\n")
    cat("Distances: ", distances, "\n")
    node = queue[1] # get...
    queue = queue[-1] # ...and remove next node
    cat("Removing node ", node, " from the queue...", "\n")
    # ...for all neighboring nodes that haven't been visited yet....
    for(i in seq_along(graph[node,])) {
      if(graph[node,i] && !visited[i]){
        # Do whatever you want to do with the node here.
        # Visit it, set the distance and add it to the queue
        visited[i] = TRUE
        distances[i] = distances[node] + 1
        queue = c(queue, i)
        cat("Visiting node ", i, ", setting its distance to ", distances[i], " and adding it to the queue", "\n")
      }
    }
  }
  cat("No more nodes in the queue. Distances: ", distances, "\n")
  return (distances)
}
