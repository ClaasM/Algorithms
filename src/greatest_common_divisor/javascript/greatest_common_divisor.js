/**
 * Recursive implementation to find the gcd (greatest common divisor) of two integers using the euclidean algorithm.
 * For more than two numbers, e.g. three, you can box it like this: gcd(a,gcd(b,greatest_common_divisor.c)) etc.
 * This runs in O(log(n)) where n is the maximum of a and b.
 * @param a the first integer
 * @param b the second integer
 * @return the greatest common divisor (gcd) of the two integers.
 */
const gcd = function (a, b) {
    if (b === 0) return a;
    return gcd(b, a % b);
};

module.exports = {gcd}
