import math

from a_star import a_star

small_graph_distances = [
    [0, 3, 4, 0, 0, 0],
    [0, 0, 0, 6, 10, 0],
    [0, 5, 0, 8, 0, 0],
    [0, 0, 0, 0, 7, 3],
    [0, 0, 0, 0, 0, 9],
    [0, 0, 0, 0, 0, 0],
]
small_graph_coordinates = [
    [0, 2],
    [2, 0],
    [2, 4],
    [6, 0],
    [6, 4],
    [8, 2]
]
# As a heuristic we use straight line distance
heuristic = []
for i in range(len(small_graph_distances)):
    heuristic.append([])
    for j in range(len(small_graph_distances[i])):
        x1 = small_graph_coordinates[i][0]
        y1 = small_graph_coordinates[i][1]
        x2 = small_graph_coordinates[j][0]
        y2 = small_graph_coordinates[j][1]
        heuristic[i].append(math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)))

# print(heuristic)

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
#


print(a_star(small_graph_distances, heuristic, 0, 5))
