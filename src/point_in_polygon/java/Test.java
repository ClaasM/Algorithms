package point_in_polygon.java;

import dijkstra.java.simple.Dijkstra;

import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        int[][] polygon = {
                {2, 1},
                {3, 1},
                {3, 3},
                {4, 3},
                {6, 1},
                {6, 5},
                {3, 5},
                {2, 4},
        };

        int[] point_1 = {1, 2};
        int[] point_2 = {5, 4};

        // Should be false
        System.out.println(PointInPolygon.pointInPolygon(polygon, point_1));
        // Should be true
        System.out.println(PointInPolygon.pointInPolygon(polygon, point_2));

    }
}


