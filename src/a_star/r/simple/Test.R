source("src/a_star/r/simple/AStar.R")

small_graph_distances = matrix(c(
  0, 3, 4, 0, 0, 0,
  0, 0, 0, 6, 10, 0,
  0, 5, 0, 8, 0, 0,
  0, 0, 0, 0, 7, 3,
  0, 0, 0, 0, 0, 9,
  0, 0, 0, 0, 0, 0
), nrow=6, ncol=6, byrow=TRUE)

small_graph_coordinates = matrix(c(
  0, 2,
  2, 0,
  2, 4,
  6, 0,
  6, 4,
  8, 2
), nrow=6,ncol=2, byrow=TRUE)

print(small_graph_coordinates)

# As a heuristic we use straight line distance
heuristic = dist(small_graph_coordinates, method = "euclidean")

# Bigger graph specifically for this algorithm
# TODO

# TODO could also use array position as coordinates

# Should be 12
# With debug statements, should print:
# visiting 0 with priority 6
# Updating distance of node 1 to 3 and priority to 5.3
# Updating distance of node 2 to 4 and priority to 5.3
# visiting 1 with priority 5.3
# Updating distance of node 3 to 9 and priority to 11.3
# Updating distance of node 4 to 13 and priority to 15.2
# visiting 2 with priority 5.3
# (not updating 1)
# Updating distance of node 4 to 12 and priority to 14.2
# visiting 3 with priority 11.3
# (no updating 4)
# Updating distance of node 5 to 12 and priority to 12
print(a_star(small_graph_distances, as.matrix(heuristic), 1, 6))