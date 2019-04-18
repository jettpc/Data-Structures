package Euler;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * NOTE: 32 bit int can represent values between + and - 2,147,483,647
 *       64 bit long can represent values between + and - 9,223,372,036,854,775,807
 * A long might be able to represent the sum all all the prime numbers, but it is highly unlikely.
 * Also will need an efficient algorithm for finding if a number is prime.
 */
public class P10_Summation_of_primes {


    void sieveOfEratosthenes(int n)
    {
        long total = 0;
        // Create a boolean array "prime[0..n]"
        boolean prime[] = new boolean[n+1];
        //initialize elements as true.
        for(int i = 0; i < n; i++)
            prime[i] = true;

        for(int j = 2; j * j <=n; j++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[j] == true)
            {
                // Update all multiples of p
                for(int i = j * 2; i <= n; i += j) //A value in prime[i] will finally be false if i is Not a prime, else true.
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true) {
                total += i;
            }
        }
        System.out.println(total); //142,913,828,922
    }
    // Driver Program to test above function
    public static void main(String args[])
    {
        int n = 2000000;
        P10_Summation_of_primes g = new P10_Summation_of_primes();
        g.sieveOfEratosthenes(n);
    }
}
