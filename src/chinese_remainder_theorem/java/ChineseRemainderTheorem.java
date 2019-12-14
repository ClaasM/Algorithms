package chinese_remainder_theorem.java;

/**
 * Used to perform the Chinese-Remainder-Theorem (crt) Algorithm using the extended euclidean algorithm.
 */
public class ChineseRemainderTheorem {

    /**
     * Calculates an integer x such that x % numerals[i] = remainder[i] for all i using the chinese remainder theorem,
     * which in turn uses the extended euclidean algorithm.
     * This has a runtime of O(|N|^2) (|N| = number of Numerals)
     * @param numerals the numerals with which the modulo is calculated
     * @param remainders the results of the modulo calculations
     * @return the first argument of the modulo operations
     */
    public static int crt(int numerals[], int remainders[]) {
        //Calculate the product of all numerals
        int product = numerals[0];
        for (int i = 1; i < numerals.length; i++) {
            product *= numerals[i];
        }

        //TODO
        return 0;
    }
}
