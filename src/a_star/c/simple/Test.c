package a_star.c.simple;

import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        // Smaller graph used for dijkstra
        int[][] small_graph_distances = {
                {0, 3, 4, 0, 0, 0},
                {0, 0, 0, 6, 10, 0},
                {0, 5, 0, 8, 0, 0},
                {0, 0, 0, 0, 7, 3},
                {0, 0, 0, 0, 0, 9},
                {0, 0, 0, 0, 0, 0},
        };
        int[][] small_graph_coordinates = {
                {0, 2},
                {2, 0},
                {2, 4},
                {6, 0},
                {6, 4},
                {8, 2}
        };
        // As a heuristic we use straight line distance
        double[][] heuristic = new double[small_graph_distances.length][small_graph_distances[0].length];
        for (int i = 0; i < small_graph_distances.length; i++) {
            for (int j = 0; j < small_graph_distances[i].length; j++) {
                double x1 = small_graph_coordinates[i][0];
                double y1 = small_graph_coordinates[i][1];
                double x2 = small_graph_coordinates[j][0];
                double y2 = small_graph_coordinates[j][1];
                heuristic[i][j] = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
            }
        }

        System.out.println(Arrays.toString(heuristic));

        // Bigger graph specifically for this algorithm
        // TODO

        // TODO could also use array position as coordinates

        // Should be 12
        // With debug statements, should print:
        // visiting 0 with priority 6
        // Updating distance of node 1 to 3 and priority to 5.3
        // Updating distance of node 2 to 4 and priority to 5.3
        // visiting 1 with priority 5.3
        // Updating distance of node 3 to 9 and priority to 11.3
        // Updating distance of node 4 to 13 and priority to 15.2
        // visiting 2 with priority 5.3
        // (not updating 1)
        // Updating distance of node 4 to 12 and priority to 14.2
        // visiting 3 with priority 11.3
        // (no updating 4)
        // Updating distance of node 5 to 12 and priority to 12
        //



        System.out.println(AStar.aStar(small_graph_distances, heuristic, 0, 5));
    }
}


