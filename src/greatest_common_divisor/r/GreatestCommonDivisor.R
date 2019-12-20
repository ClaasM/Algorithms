gcd <- function (a,b) {
  #' Recursive implementation to find the gcd (greatest common divisor) of two integers using the euclidean algorithm.
  #' For more than two numbers, e.g. three, you can box it like this: gcd(a,gcd(b,greatest_common_divisor.c)) etc.
  #' This runs in O(log(n)) where n is the maximum of a and b.
  #' @param a the first integer
  #' @param b the second integer
  #' @return the greatest common divisor (gcd) of the two integers.
  print(sprintf("New *a* is %s, new *b* is %s",a,b))
  if(b == 0){
    print(sprintf("b is 0, stopping recursion, a is the gcd: %s", a))
    return (a)
  }
  print(sprintf("Recursing with new a = b and new b = a %% b..."))
  gcd(b, a %% b)
}

print(gcd(10,20))
