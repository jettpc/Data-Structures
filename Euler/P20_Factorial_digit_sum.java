package Euler;

import java.math.BigInteger;

public class P20_Factorial_digit_sum {

    /**
     * n! means n × (n − 1) × ... × 3 × 2 × 1
     *
     * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
     * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
     *
     * Find the sum of the digits in the number 100!
     */
    public static void main(String[] args) {
        int answer = factorialDigitSum();
        System.out.println(answer);
    }

    public static int factorialDigitSum() {
        BigInteger val = new BigInteger("1");

        for(int i = 2; i <= 100; i++) {
            val = val.multiply(BigInteger.valueOf(i));
        }

        String s = val.toString();
        int totalDigitSum = 0;

        for(int i = 0; i < s.length(); i++) {
            totalDigitSum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return totalDigitSum;
    }
}
