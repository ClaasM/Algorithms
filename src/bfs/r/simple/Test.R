source("src/bfs/r/simple/BFS.R")

graph = matrix(c(
  FALSE, TRUE, TRUE, FALSE, FALSE, FALSE,
  FALSE, FALSE, FALSE, TRUE, TRUE, FALSE,
  FALSE, TRUE, FALSE, TRUE, FALSE, FALSE,
  FALSE, FALSE, FALSE, FALSE, TRUE, TRUE,
  FALSE, FALSE, FALSE, FALSE, FALSE, TRUE,
  FALSE, FALSE, FALSE, FALSE, FALSE, FALSE
), nrow=6, ncol=6, byrow=TRUE)

# Should be [0, 1, 1, 2, 2, 3]
print(bfs(graph, 1))