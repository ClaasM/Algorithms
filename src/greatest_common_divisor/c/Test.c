#include <stdio.h>
#include "GreatestCommonDivisor.c"

int main()
{
   printf("%d\n", gcd(16,24)); // Should be 8
   printf("%d\n", gcd(17,31)); // Should be 1
}