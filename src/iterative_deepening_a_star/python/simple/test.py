import math

from iterative_deepening_a_star import iterative_deepening_a_star


# Has to be a tree.
small_tree_distances = [
    [0, 3, 3, 0, 0, 0, 0],
    [0, 0, 0, 3, 3, 0, 0],
    [0, 0, 0, 0, 0, 3, 0],
    [0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 3],
    [0, 0, 0, 0, 0, 0, 0],
]
small_tree_coordinates = [
    [5, 1],
    [3, 3],
    [7, 3],
    [1, 5],
    [5, 5],
    [9, 5],
    [7, 7]
]

# As a heuristic we use straight line distance
heuristic = []
for i in range(len(small_tree_distances)):
    heuristic.append([])
    for j in range(len(small_tree_distances[i])):
        x1 = small_tree_coordinates[i][0]
        y1 = small_tree_coordinates[i][1]
        x2 = small_tree_coordinates[j][0]
        y2 = small_tree_coordinates[j][1]
        heuristic[i].append(math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)))

    

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
print(iterative_deepening_a_star(small_tree_distances, heuristic, 0, 6))
