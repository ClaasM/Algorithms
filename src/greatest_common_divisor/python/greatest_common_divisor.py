# Recursive implementation to find the gcd (greatest common divisor) of two integers using the euclidean algorithm.
# For more than two numbers, e.g. three, you can box it like this: gcd(a,gcd(b,greatest_common_divisor.c)) etc.
# This runs in O(log(n)) where n is the maximum of a and b.
# @param a the first integer
# @param b the second integer
# @return the greatest common divisor (gcd) of the two integers.


def gcd(a, b):
    # print("New *a* is " + str(a) + ", new *b* is " + str(b))
    if b == 0:
        # print("b is 0, stopping recursion, a is the gcd: " + str(a))
        return a
    # print("Recursing with new a = b and new b = a % b...")
    return gcd(b, a % b)
