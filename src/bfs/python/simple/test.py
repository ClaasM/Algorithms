from bfs import bfs


graph = [
    [False, True, True, False, False, False],
    [False, False, False, True, True, False],
    [False, True, False, True, False, False],
    [False, False, False, False, True, True],
    [False, False, False, False, False, True],
    [False, False, False, False, False, False],
]

# Should be [0, 1, 1, 2, 2, 3]
print(bfs(graph, 0))
    

