/**
 *  A math class that handles primes, fibonnaci, and perfects iteratively.
 *  Function that checks if a number is prime, function that returns the nth
 *  Fibonacci number, function that checks if a number is perfect, and a function
 *  that prints out the first four perfect numbers. Two additional functions do the
 *  same but with Mersenne Primes and Even Perfect Numbers.
 *  it represents, and how to use it.
 *
 *  @author  Rohan Chaudhary
 *  @version 9-28-2024
 *  @author  Period: 2
 *  @author  Assignment: JMCh08_PerfectNumbers
 *
 *  @author  Sources: N/A
 */
public class MyMath
{
    /**
     * Returns true if n is a prime; otherwise returns false.
     * @param n  number to check if prime
     * @return  true if n is a prime; otherwise returns false
     */
    public static boolean isPrime( int n )
    {
        if ( n <= 1 )
            return false;

        int m = 2;

        while ( m * m <= n )
        {
            if ( n % m == 0 )
                return false;
            m++;
        }

        return true;
    }

    public static int pow( int base, int exponent) 
    {
        int output = 1;
        for (int i = 0; i < exponent; i++) 
        {
            output *= base;
        }
        return output;
    }
    /**
     * Question 8-15 Returns the n-th Fibonacci number
     * 
     * Find and read a few informative websites dedicated to Fibonacci numbers.
     * The following recursive method returns the n-th Fibonacci number:
     * 
     *   // Returns the n-th Fibonacci number.
     *   // Precondition: n >= 1
     *   public static long fibonacci(int n)
     *   {
     *     if (n == 1 || n == 2)
     *       return 1;
     *     else
     *       return fibonacci(n - 1) + fibonacci(n - 2);
     *   }
     * Rewrite it without recursion, using one loop.
     *
     * @param n  Fibonacci number to find
     * @return  n-th Fibonacci number
     */
    public static long fibonacci( int n )
    {
        // Iterative Fibonnaci Code. 

        long fibOne = 0;
        long fibTwo = 1;
        long total = 0;
        for (int i = 0; i <= n; i++) 
        {
            if (i == 0) 
            {
                total += fibOne;
            }
            else if (i == 1) 
            {
                total += fibTwo;
            }
            else 
            {
                total = (fibOne + fibTwo);
                fibOne = fibTwo;
                fibTwo = total;
                
            }
        }
        
        return total; 
    }


    /**
     * Returns true if n is a perfect number, false otherwise.
     * 
     * @param n  number to test
     * @return   true if n is a perfect number, false otherwise.
     */
    public static boolean isPerfect( int n )
    {
        int sum = 0;
        // Get the Sum of all of n's Divisors
        for (int i = 1; i < n; i++) 
        {
            if (n % i == 0) 
            {
                sum += i;
            }
        }
        // Checks if equal to N
        if (sum == n) 
        {
            return true;
        }

        return false; 
    }


    /**
     * Prints the first n perfect numbers
     * 
     * @param n number of perfect numbers to print
     */
    public static void printPerfectNums( int n )
    {
        System.out.println( "Perfect numbers: " );
        int count = 0;
        for ( int k = 1; count < n; k++ )
        {
            if ( isPerfect( k ) )
            {
                System.out.print( k + " " );
                count++;
            }
        }
        System.out.println();
    }


    /**
     * Prints the first n Mersenne primes
     * TODO Replace Math.POW
     * @param n number of Mersenne primes to print
     */
    public static void printMersennePrimes( int n )
    {
        System.out.println( "Mersenne primes: " );
        int numFound = 0;
        int currNum = 0;
        // Iterate until Mersenne Primes found
        for (int i = 0; numFound < n; i++) 
        {
            currNum = (int)(pow(2,i) - 1); 
            if (isPrime(currNum)) 
            {
                System.out.print( currNum + " ");
                numFound += 1;
            }
        }

        System.out.println();
    }


    /**
     * Prints the first n even perfect numbers
     */
    public static void printEvenPerfectNums( int n )
    {
        System.out.println( "Even perfect numbers: " );

        int numFound = 0;
        int currNum = 0;
        // Iterate until Mersenne Primes found
        for (int i = 0; numFound < n; i++) 
        {

            currNum = (int)(pow(2,i) - 1); 

            if (isPrime(currNum)) 
            {
                System.out.print( currNum * ((long)Math.pow(2.0,i-1))+ " " );
                numFound += 1;
            }
            
        }

        System.out.println();
    }


    /*********************************************************************/

    public static void main( String[] args )
    {
        int n = 19;
        System.out.println( n + "-th Fibonacci number = " + fibonacci( n ) );

        printPerfectNums( 4 );
        printMersennePrimes( 6 );
        printEvenPerfectNums( 6 );
    }
}
/*
19-th Fibonacci number = 4181
Perfect numbers: 
6 28 496 8128 
Mersenne primes: 
3 7 31 127 8191 131071
Even perfect numbers: 
6 28 496 8128 33550336 8589869056
*/
