point_in_polygon <- function(polygon, point){
  #' Raycasting Algorithm to find out whether a point is in a given polygon.
  #' Performs the even-odd-rule Algorithm to find out whether a point is in a given polygon.
  #' This runs in O(n) where n is the number of edges of the polygon.
  #' @param polygon an array representation of the polygon where polygon[i,1] is the x Value of the i-th point and polygon[i,2] is the y Value.
  #' @param point   an array representation of the point where point[1] is its x Value and point[2] is its y Value
  #' @return whether the point is in the polygon (not on the edge, just turn < into <= and > into >= for that)
  
  # A point is in a polygon if a line from the point to infinity crosses the polygon an odd number of times
  odd = FALSE
  # For each edge (In this case for each point of the polygon and the previous one)
  i = 0
  j = nrow(polygon) - 1
  while(i < nrow(polygon) - 1){
    i = i + 1
    # If a line from the point into infinity crosses this edge
    # One point needs to be above, one below our y coordinate
    # ...and the edge doesn't cross our Y corrdinate before our x coordinate (but between our x coordinate and infinity)
    if (((polygon[i,2] > point[2]) != (polygon[j,2] > point[2])) 
        && (point[1] < ((polygon[j,1] - polygon[i,1]) * (point[2] - polygon[i,2]) / (polygon[j,2] - polygon[i,2])) + polygon[i,1])){
      # Invert odd
      odd = !odd
    }
    j = i
  }
  # If the number of crossings was odd, the point is in the polygon
  return (odd)
}
