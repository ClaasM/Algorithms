from point_in_polygon import point_in_polygon

polygon = [[2, 1], [3, 1], [3, 3], [4, 3], [6, 1], [6, 5], [3, 5], [2, 4]]
point_1 = [1, 2]
point_2 = [5, 4]

# Should be False
print(point_in_polygon(polygon, point_1))
# Should be True
print(point_in_polygon(polygon, point_2))
