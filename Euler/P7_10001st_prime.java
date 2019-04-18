package Euler;

public class P7_10001st_prime {
    /**
     *  By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
     *
     * What is the 10 001st prime number?
     */
    public static void main(String[] args) {
        int answer = countPrimeNums();
        System.out.println(answer); //answer is 104743
    }

    public static int countPrimeNums() {
        int primeCounter = 2;
        int possiblePrimeNum = 5;


        while(primeCounter < 10001) {
            if (isPrime(possiblePrimeNum)) {
                primeCounter++;
                System.out.println("Prime counter : " + primeCounter + " , Prime number : " + possiblePrimeNum);
            }
            possiblePrimeNum++;
        }

        return possiblePrimeNum - 1;
    }

    /**
     * check is the number is prime
     * a prime number is: a whole number greater than 1 whose only factors are 1 and itself
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
