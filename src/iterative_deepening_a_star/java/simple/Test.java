package iterative_deepening_a_star.java.simple;

import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        // Has to be a tree.
        int[][] small_tree_distances = {
                {0, 3, 3, 0, 0, 0, 0},
                {0, 0, 0, 3, 3, 0, 0},
                {0, 0, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 3},
                {0, 0, 0, 0, 0, 0, 0},
        };
        int[][] small_tree_coordinates = {
                {5, 1},
                {3, 3},
                {7, 3},
                {1, 5},
                {5, 5},
                {9, 5},
                {7, 7}
        };

        // As a heuristic we use straight line distance
        double[][] heuristic = new double[small_tree_distances.length][small_tree_distances[0].length];
        for (int i = 0; i < small_tree_distances.length; i++) {
            for (int j = 0; j < small_tree_distances[i].length; j++) {
                double x1 = small_tree_coordinates[i][0];
                double y1 = small_tree_coordinates[i][1];
                double x2 = small_tree_coordinates[j][0];
                double y2 = small_tree_coordinates[j][1];
                heuristic[i][j] = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
            }
        }
        // Threshold 6.3
        // Visiting 0
        // Visiting 1
        // Breach
        // Visiting 2
        // Breach
        // Threshold 7
        // Visiting 0
        // Visiting 1
        // Breach
        // Visiting 2
        // Visiting 5
        // Breach
        // Threshold 8,6
        // Visiting 0
        // Visiting 1
        // Visiting 3
        // Breach
        // Visiting 4
        // No neighbors
        // Visiting 2
        // Visiting 5
        // Visiting 6

        // Should be 9
        System.out.println(IterativeDeepeningAStar.iterativeDeepeningAStar(small_tree_distances, heuristic, 0, 6));
    }
}

