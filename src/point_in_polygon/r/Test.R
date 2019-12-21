source("src/point_in_polygon/r/PointInPolygon.R")


polygon = matrix(c(2, 1, 3, 1, 3, 3, 4, 3, 6, 1, 6, 5, 3, 5, 2, 4), nrow=8, ncol=2, byrow=TRUE)
point_1 = c(1, 2)
point_2 = c(5, 4)

# Should be FALSE
print(point_in_polygon(polygon, point_1))
# Should be TRUE
print(point_in_polygon(polygon, point_2))
