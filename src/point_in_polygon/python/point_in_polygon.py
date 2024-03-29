def point_in_polygon(polygon, point):
    """
    Raycasting Algorithm to find out whether a point is in a given polygon.
    Performs the even-odd-rule Algorithm to find out whether a point is in a given polygon.
    This runs in O(n) where n is the number of edges of the polygon.
     *
    :param polygon: an array representation of the polygon where polygon[i][0] is the x Value of the i-th point and polygon[i][1] is the y Value.
    :param point:   an array representation of the point where point[0] is its x Value and point[1] is its y Value
    :return: whether the point is in the polygon (not on the edge, just turn < into <= and > into >= for that)
    """

    # A point is in a polygon if a line from the point to infinity crosses the polygon an odd number of times
    odd = False
    # For each edge (In this case for each point of the polygon and the previous one)
    j = len(polygon) - 1
    for i in range(1,len(polygon)):
        # If a line from the point into infinity crosses this edge
        # One point needs to be above, one below our y coordinate
        # ...and the edge doesn't cross our Y corrdinate before our x coordinate (but between our x coordinate and infinity)
        
        # edge not parallel to x-axis (singularity)
        if polygon[j][1] != polygon[i][1]:
            # point between y-coordinates of edge
            if (polygon[i][1] > point[1]) != (polygon[j][1] > point[1]):
                # x-coordinate of intersection
                Qx = (polygon[j][0] - polygon[i][0]) * (point[1] - polygon[i][1]) / (polygon[j][1] - polygon[i][1]) + polygon[i][0]
                if point[0] < Qx:
                    # Invert odd
                    odd = not odd
        j = i
    # If the number of crossings was odd, the point is in the polygon
    return odd