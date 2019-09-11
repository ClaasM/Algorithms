package dijkstra.java.simple;

import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 3, 1, 0, 0, 0},
                {0, 0, 0, 2, 1, 0},
                {0, 4, 0, 4, 0, 0},
                {0, 0, 0, 0, 3, 2},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
        };

        // Should be [0, 3, 1, 5, 4, 5]
        System.out.println(Arrays.toString(Dijkstra.dijkstra(graph, 0)));
    }
}


