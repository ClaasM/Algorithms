const {pointInPolygon} = require('./point_in_polygon')

const polygon = [[2, 1], [3, 1], [3, 3], [4, 3], [6, 1], [6, 5], [3, 5], [2, 4]];
const point_1 = [1, 2];
const point_2 = [5, 4];

// Should be false
console.log(pointInPolygon(polygon, point_1));
// Should be true
console.log(pointInPolygon(polygon, point_2));