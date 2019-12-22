bottom_reached = FALSE  # Variable to keep track if we have reached the bottom of the tree

iterative_deepening_dfs <- function(start, target){
  #' Implementation of iterative deepening DFS (depth-first search) algorithm to find the shortest path from a start to a target node..
  #' Given a start node, this returns the node in the tree below the start node with the target value (or null if it doesn't exist)
  #' Runs in O(n), where n is the number of nodes in the tree, or O(b^d), where b is the branching factor and d is the depth.
  #' @param start  the node to start the search from
  #' @param target the value to search for
  #' @return The node containing the target value or null if it doesn't exist.
  
  # Start by doing DFS with a depth of 1, keep doubling depth until we reach the "bottom" of the tree or find the node we're searching for
  depth = 1
  while(!bottom_reached){
    bottom_reached <<- TRUE # One of the "end nodes" of the search with this depth has to still have children and set this to false again
    # One of the "end nodes" of the search with this depth has to still have children and set this to FALSE again
    result = iterative_deepening_dfs_rec(start, target, 0, depth)
    if(!is.null(result)){
      # We've found the goal node while doing DFS with this max depth
      return (result)
    }
    # We haven't found the goal node, but there are still deeper nodes to search through
    depth = depth * 2
    cat("Increasing depth to ", depth, "\n")
    print(bottom_reached)
  }
  # Bottom reached is TRUE.
  # We haven't found the node and there were no more nodes that still have children to explore at a higher depth.
  return (NULL)
}

iterative_deepening_dfs_rec <- function(node, target, current_depth, max_depth) {
  cat("Visiting Node ", node$value, "\n")
  
  if(node$value == target){
    # We have found the goal node we we're searching for
    print("Found the node we're looking for!")
    return (node)
  }
  
  if(current_depth == max_depth) {
    print("Current maximum depth reached, returning...")
    # We have reached the end for this depth...
    if(length(node$children) > 0){
      # ...but we have not yet reached the bottom of the tree
      bottom_reached <<- FALSE
    }
    return (NULL)
  }
  
  # Recurse with all children
  for (i in seq_along(node$children)){
    result = iterative_deepening_dfs_rec(node$children[[i]], target, current_depth + 1, max_depth)
    if(!is.null(result)){
      # We've found the goal node while going down that child
      return (result)
    }
  }
  # We've gone through all children and not found the goal node
  return (NULL)
}
