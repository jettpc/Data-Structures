package Euler;

import java.math.BigInteger;

public class P16_Power_digit_sum {

    /**
     * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
     *
     * What is the sum of the digits of the number 2^1000?
     *
     */

    public static void main(String [] args) {
        int answer = powerDigitSum();
        System.out.println(answer);
    }

    public static int powerDigitSum() {

        String valOfPower = xRaisedToThePower(2, 1000);

        int total = 0;
        for(int i = 0; i < valOfPower.length(); i++) {
            //Integer.parseInt(String) returns an Int. String.valueOf(char) returns a String. .charAt(int) returns char
            total += Integer.parseInt(String.valueOf(valOfPower.charAt(i)));
        }
        return total;
    }

    public static String xRaisedToThePower(int x, int raisedToThe) {
        BigInteger calc = new BigInteger("1");
        if(raisedToThe < 1) {
            System.out.println(raisedToThe + " is less than 1");
            return "1";
        }
        for(int i = 1; i <= raisedToThe; i++) {
            calc = calc.multiply(BigInteger.valueOf(x));
        }
        String answer = calc.toString();
        return answer;
    }
}
