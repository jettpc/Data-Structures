package Euler;

public class P21_Amicable_numbers {

    /**
     * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
     * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
     *
     * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
     *
     * Evaluate the sum of all the amicable numbers under 10000.
     */

    public static void main(String[] args) {
        int answer = amicableSum();
        System.out.println(answer);
    }

    public static int amicableSum() {
       int a = 1;
       int b = 1;
        int sum = 0; //starting off with the edge case of adding 1 to the table
        boolean[] amicableNumsTable = new boolean[10000];

        for(int i = 0; i < 10000; i++) {
            if(amicableNumsTable[i] == false) { //if a doesn't exist in the table of already existing amicable numbers
                a = properDivisorsSum(i); //if i is 220, a will be 284
                b = properDivisorsSum(a); //if a is 284, b will be 220, meaning add i and b to the table
                if(b == i && a != b) { //amicable pair exists - If d(a) = b and d(b) = a, where a ≠ b
                    amicableNumsTable[a] = true;
                    amicableNumsTable[b] = true;
                    sum+=a;
                    sum+=b;
                }
            }
        }
    System.out.println(sum);
        //calculate sum of proper divisors of n (numbers less than n which divide evenly into n)
        System.out.println(properDivisorsSum(0));




        return 1;
    }

    public static int properDivisorsSum(int num) {
        if(num == 1) {
            return 1;
        }
        int sum = 0;
        for(int i = 1; i < num; i++) {
            if(num % i == 0) {//the number is evenly divisible
                System.out.println("divisors : " + i);
                sum+=i;
            }
        }
        return sum;
    }


}
