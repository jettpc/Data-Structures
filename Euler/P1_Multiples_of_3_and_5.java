package Euler;

/**
 * Author: Paul Jett - hire me :)
 * I do these problems a lot, this question is similar to project euler's first question.
 * I also enjoy questions on Hackerrank, Cracking the Coding Interview, and Google's dev guide.
 */

public class P1_Multiples_of_3_and_5 {
    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 100.
     */
    public static void main(String[] args) {
        System.out.println(bruteForce_sum_mult_3_and_5_below_1000()); //233168
        System.out.println(sum_mult_3_and_5_below_1000()); //233168
    }

    /**
     * BRUTE FORCE SOLUTION
     * @return sum of multiples of 3 or 5 below 1000
     */
    public static int bruteForce_sum_mult_3_and_5_below_1000() {
        int sum = 0;
        for(int i = 3; i < 1000; i++) {
            if(i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Slightly more optimal solution
     * @return sum of multiples of 3 or 5 below 1000
     */
    public static int sum_mult_3_and_5_below_1000() {
        int sum = 0;
        for(int i = 3; i < 1000; i += 3) {
            sum += i;
        }
        for(int i = 5; i < 1000; i += 5) {
            if(i % 3 != 0) {
                sum += i;
            }
        }
        return sum;
    }
}
