package bfs.java.simple;

import dijkstra.java.simple.Dijkstra;

import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        boolean[][] graph = {
                {false, true, true, false, false, false},
                {false, false, false, true, true, false},
                {false, true, false, true, false, false},
                {false, false, false, false, true, true},
                {false, false, false, false, false, true},
                {false, false, false, false, false, false},
        };

        // Should be [0, 1, 1, 2, 2, 3]
        System.out.println(Arrays.toString(BFS.bfs(graph, 0)));
    }
}


