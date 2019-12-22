dfs <- function(start, target) {
  #' Implementation of DFS (depth-first search) algorithm to find the shortest path from a start to a target node..
  #' Given a start node, this returns the node in the tree below the start node with the target value (or null if it doesn't exist)
  #' Runs in O(n), where n is the number of nodes in the tree, or O(b^d), where b is the branching factor and d is the depth.
  #' @param start  the node to start the search from
  #' @param target the value to search for
  #' @return The node containing the target value or null if it doesn't exist.
  
  cat("Visiting Node ", start$value, "\n")
  if(start$value == target){
    # We have found the goal node we we're searching for
    print("Found the node we're looking for!")
    return (start)
  }

  # Recurse with all children
  for(i in seq_along(start$children)) {
    result = dfs(start$children[[i]], target)
    if (!is.null(result)) {
      # We've found the goal node while going down that child
      return (result)
    }
  }
  
  # We've gone through all children and not found the goal node
  cat("Went through all children of ", start$value, ", returning to it's parent.", "\n")
  return (NULL)
}