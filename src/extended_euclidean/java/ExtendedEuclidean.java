package extended_euclidean.java;

/**
 * Used to perform the Extended Euclidean Algorithm.
 */
public class ExtendedEuclidean {


    /**
     * Performs the extended euclidean algorithm (extended euclid) to find the greatest common divisor (gcd) of two integers a and b,
     * as well as two integers s and t such that gcd = s*a + t*b.
     * This runs in O(log(n)) where n is the maximum of a and b, just like the normal euclidean algorithm to find a gcd.
     * @param a the first integer
     * @param b the second integer
     * @return an object containing three fields s, t and gcd
     */
    public static Result extendedEuclidean(int a, int b) {
        Result result = new Result();
        if (b == 0) {
            // We're done, end of recursion
            result.gcd = a;
            result.s = 1;
            result.t = 0;
        } else {
            // Make a recursive call
            result = extendedEuclidean(b, a % b);
            //Calculate new factors s and t and switch them since we switched the arguments in the recursive call
            int temp = result.s - result.t * (a / b);
            result.s = result.t;
            result.t = temp;
        }
        return result;
    }

    /**
     * Helper class to return the result.
     * contains integers gcd, s and t such that gcd = s*a + t*b
     */
    private static class Result {
        public int gcd, s, t;
    }
}
