package least_common_multiple.java;

/**
 * Used to perform the Euclidean Algorithm to find the greatest common divisor (gcd) of two numbers.
 * For more than two numbers, e.g. three, you can box it like this: gcd(a,gcd(b,greatest_common_divisor.c)) etc.
 */
public class LeastCommonMultiple {

    /**
     * Implementation to find the lcm (least common multiple) of two integers using the gcd.
     * This runs in O(log(n)) where n is the maximum of a and b (because gcd runs in O(log(n))).
     * @param a the first integer
     * @param b the second integer
     * @return the least common multiple (lcm) of the two integers.
     */
    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    /**
     * Recursive implementation to find the gcd (greatest common divisor) of two integers.
     * This runs in O(log(n)) where n is the maximum of a and b.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor (gcd) of the two integers.
     */
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
