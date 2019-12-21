iterative_deepening_a_star <- function(tree, heuristic, start, goal){
  #' Performs the iterative deepening A Star (A*) algorithm to find the shortest path from a start to a target node.
  #' Can be modified to handle graphs by keeping track of already visited nodes.
  #' @param tree      An adjacency-matrix-representation of the tree where (x,y) is the weight of the edge or 0 if there is no edge.
  #' @param heuristic An estimation of distance from node x to y that is guaranteed to be lower than the actual distance. E.g. straight-line distance.
  #' @param start     The node to start from.
  #' @param goal      The node we're searching for.
  #' @return number shortest distance to the goal node. Can be easily modified to return the path.
  
  threshold = heuristic[start,goal]
  repeat{
    cat("Iteration with threshold: ", threshold, "\n")
    distance = iterative_deepening_a_star_rec(tree, heuristic, start, goal, 0, threshold)
    if(distance == Inf){
      # Node not found and no more nodes to visit
      return -1
    }else if (distance < 0){
      # if we found the node, the function returns the negative distance
      print("Found the node we're looking for!")
      return (-distance)
    }else{
      # if it hasn't found the node, it returns the (positive) next-bigger threshold
      threshold = distance
    }
  }
}

iterative_deepening_a_star_rec <- function(tree, heuristic, node, goal, distance, threshold){
  #' Performs DFS up to a depth where a threshold is reached (as opposed to interative-deepening DFS which stops at a fixed depth).
  #' Can be modified to handle graphs by keeping track of already visited nodes.
  #' @param tree      An adjacency-matrix-representation of the tree where (x,y) is the weight of the edge or 0 if there is no edge.
  #' @param heuristic An estimation of distance from node x to y that is guaranteed to be lower than the actual distance. E.g. straight-line distance.
  #' @param node      The node to continue from.
  #' @param goal      The node we're searching for.
  #' @param distance  Distance from start node to current node.
  #' @param threshold Until which distance to search in this iteration.
  #' @return number shortest distance to the goal node. Can be easily modified to return the path.
  
  cat("Visiting Node ", node, "\n")
  
  if(node == goal){
    # We have found the goal node we we're searching for
    return (-distance)
  }
  estimate = distance + heuristic[node,goal]
  if(estimate > threshold){
    cat("Breached threshold with heuristic: ", estimate, "\n")
    return (estimate)
  }
  # ...then, for all neighboring nodes....
  min = Inf
  for(i in seq_along(tree[node,])) {
    if(tree[node,i] != 0){
      t = iterative_deepening_a_star_rec(tree, heuristic, i, goal, distance + tree[node,i], threshold)
      if(t < 0){
        # Node found
        return (t)
      } else if  (t < min){
        min = t
      }
    }
  }
  
  return (min)
}