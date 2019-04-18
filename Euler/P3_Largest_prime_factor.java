package Euler;

public class P3_Largest_prime_factor {
    /**
     * The prime factors of 13195 are 5, 7, 13 and 29.
     *
     * What is the largest prime factor of the number 600851475143 ?
     */
    public static void main(String args[]) {
        /**
         *  NOTE: cant use int or int arithmetic because 600851475143 > 32 bit representation of ~4 billion values
         *  NOTE: only have to iterate half of 600851475143, since you can't have a prime factor over half the value
         *  of the number itself. largest prime factor of 10 = 5. 6 wouldn't make sense because the smallest whole
         *  number 6 can multiply by that would make an impact is 2 which would result in 12.
         */
        long answer = largest_prime_factor();

        int[] anArray = new int[10];
        System.out.println(answer);
    }

    public static long largest_prime_factor() {
        long testNum = 600851475143l;
        int largestFactor = 0;
        long loopMax = 17425170l; //largest known prime
        for (int i = 3; i * i <= loopMax; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && testNum % i == 0) {
                System.out.println("prime factor: " + i);
                largestFactor = i;
                loopMax = (testNum / i) + 1;
            }
        }
        System.out.println("result is: " + largestFactor);
        return largestFactor;
    }

    public static boolean isPrime(long num) {
        if(num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
            return false;
        }
        return true;
    }
}
