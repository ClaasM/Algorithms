package knapsack.java;

/**
 * Created by claas on 7/14/2016.
 * Used to perform the 0-1-Knapsack algorithm with dynamic programming.
 */
public class Knapsack {
    /**
     * This performs the 0-1-knapsack algorithm.
     * It uses O(n*W) time and O(n*W) space, where n is the number of items and W is the capacity of the Knapsack.
     * @param values the values of the items
     * @param weights the weights of the items
     * @param capacity the capacity of the knapsack
     * @return the maximum attainable total value of items that fit into the knapsack.
     */
    public static int knapsack(int[] values, int[] weights, int capacity) {
        //An Array containing the maximum value attainable with total weight <= j using the first i items.
        int[][] maximum = new int[weights.length][capacity];
        //For each of the weights...
        for (int i = 1; i < weights.length; i++) {
            //...for each possible item size...
            for (int j = 0; j < capacity; j++) {
                // If the item is bigger than current capacity
                if (weights[i - 1] > j) {
                    // It's the same as without the current item.
                    maximum[i][j] = maximum[i - 1][j];
                } else {
                    // Else it's the maximum of that or the value we get if we take the maximum attainable value in a knapsack that has capacity for it and add it's value.
                    maximum[i][j] = Math.max(maximum[i - 1][j], maximum[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        //Return the maximum value attainable with the maximum capacity and all items.
        return maximum[maximum.length - 1][maximum[0].length - 1];
    }
}
