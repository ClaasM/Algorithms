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