package greatest_common_divisor.java;

/**
 * Created by claas on 7/17/2016.
 * Used to perform the Euclidean Algorithm to find the greatest common divisor (gcd) of two numbers.
 * For more than two numbers, e.g. three, you can box it like this: gcd(a,gcd(b,c)) etc.
 */
public class GreatestCommonDivisor {
    /**
     * Recursive implementation to find the gcd (greatest common divisor) of two integers using the euclidean algorithm.
     * This runs in O(log(n)) where n is the maximum of a and b.
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor (gcd) of the two integers.
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
