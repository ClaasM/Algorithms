package iterative_deepening_dfs.java.simple;

// Subclass with a convenient constructor.
class TestNode extends Node {
    public TestNode(int value, Node[] children) {
        this.value = value;
        this.children = children;
    }
}

class Test {
    public static void main(String[] args) {
        // Smaller graph used for dijkstra
        Node start = new TestNode(0, new Node[]{
                new TestNode(1, new Node[]{
                        new TestNode(3, new Node[]{}),
                        new TestNode(4, new Node[]{})
                }), new TestNode(2, new Node[]{
                        new TestNode(5, new Node[]{}),
                        new TestNode(6, new Node[]{})
                })
        });

        // Bigger graph specifically for this algorithm
        // TODO

        // Should be [0, 3, 1, 5, 4, 5]
        IterativeDeepeningDFS.iterativeDeepeningDFS(start, 6);
    }
}


