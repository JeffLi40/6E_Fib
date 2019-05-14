/**
  Calculate Fibonacci number n
  3 implementations
  @precondition: n >= 1

  Use type "long" instead of "int", because rabbits.
 */

public class Fib {
    /**
      @return the nth Fibonacci number
              by implementing the recurrence relation
     */
    public static long fib_recurrence( int n) {
        if ( n < 2) // decision between base case and recursive case
        return 1; // instructions for base case
        //instructions for recursive case
        else return fib_recurrence( n - 1) + fib_recurrence( n - 2);
                 // recursive abstraction: when I want to compute the nth fibonacci number, I can compute the (n-1)th fib#
                 //                          and the (n-2)th fib#
                 //               add'l processing: calculate n-1 and n-2
                 //                        combine: add the previous two fib#'s'
    }
     /* These are class methods because the return value is independent of the invoking object.
    */

    /* Time complexity:
       Consider the size of the problem to be n

       As the proxy for the time required, count the number of recursive calls

       Then cost of the the recurrence algorithm
       grows exponentially (proportional to 2^n)
       as the size of the problem increases,
       because each recursive call expands to two other subcalls
     */


    /**
      @return the nth Fibonacci number
              calculated via the 8th-grade algorithm
     */
    public static long fib_grade8( int n) {
        if ( n < 2) return 1;
        else {
          long fib0 = 1;
          long fib1 = 1;
          for( int fib1index = 1
             ; fib1index < n
             ; fib1 += fib0
             , fib0 = fib1 - fib0
             , fib1index++);
          return fib1;
        }
    }
    /* Time complexity:
       Consider the size of the problem to be n

       As the proxy for the time required, count the number of calculations for a fibonacci number

       Then cost of the the recurrence algorithm
       grows linearly
       as the size of the problem increases,
       because increasing n by 1 results in having to perform one addition of fib(n) and fib(n - 1)
     */


    /**
      @return the nth Fibonacci number
              calculated via Binet's formula.
              Type is double so that this exercise can
              ignore rounding issues.
     */
    public static double fib_Binet( int n) {
        double phi = .5 * ( 1 + Math.sqrt(5));
        double psi = .5 * ( 1 - Math.sqrt(5));
        return (1 / Math.sqrt(5))
             * ( Math.pow( phi, n)
               - Math.pow( psi, n)
               );

    }
    /* Time complexity:
       Consider the size of the problem to be n

       As the proxy for the time required, count the number of calculations for the nth fib#

       Then cost of the the recurrence algorithm
       is constant
       as the size of the problem increases,
       because the algorithm only involves the same number of calculations regardless of n.
     */
}
