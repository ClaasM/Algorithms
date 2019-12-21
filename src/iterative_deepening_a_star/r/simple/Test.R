source("src/iterative_deepening_a_star/r/simple/IterativeDeepeningAStar.R")

# Has to be a tree.
small_tree_distances = matrix(c(
  0, 3, 3, 0, 0, 0, 0,
  0, 0, 0, 3, 3, 0, 0,
  0, 0, 0, 0, 0, 3, 0,
  0, 0, 0, 0, 0, 0, 0,
  0, 0, 0, 0, 0, 0, 0,
  0, 0, 0, 0, 0, 0, 3,
  0, 0, 0, 0, 0, 0, 0
), nrow=7, ncol=7, byrow=TRUE)

small_tree_coordinates = matrix(c(
  5, 1,
  3, 3,
  7, 3,
  1, 5,
  5, 5,
  9, 5,
  7, 7
), nrow=7,ncol=2, byrow=TRUE)


# As a heuristic we use straight line distance
heuristic = dist(small_tree_coordinates, method = "euclidean")

# Threshold 6.3
# Visiting 0
# Visiting 1
# Breach
# Visiting 2
# Breach
# Threshold 7
# Visiting 0
# Visiting 1
# Breach
# Visiting 2
# Visiting 5
# Breach
# Threshold 8,6
# Visiting 0
# Visiting 1
# Visiting 3
# Breach
# Visiting 4
# No neighbors
# Visiting 2
# Visiting 5
# Visiting 6

# Should be 9
print(iterative_deepening_a_star(small_tree_distances, as.matrix(heuristic), 1, 7))