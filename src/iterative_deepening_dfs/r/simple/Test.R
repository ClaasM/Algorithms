source("src/iterative_deepening_dfs/r/simple/IterativeDeepeningDFS.R")


start = list(value=0, children=list(
  list(value=1, children=list(
    list(value=3, children=list()),
    list(value=4, children=list())
  )),
  list(value=2, children=list(
    list(value=5, children=list()),
    list(value=6, children=list())
  ))
))


# Bigger graph specifically for this algorithm
# TODO

# Should be 6
print(iterative_deepening_dfs(start, 6)$value)

