package Euler;

public class P5_Smallest_multiple {
    /**
     * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
     *
     * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     */
    public static void main(String[] args) {

        int answer = evenly_div_1_20();
        System.out.println(answer); //232792560
    }

    public static int evenly_div_1_20() {
        int num =2;
        boolean fastBreak = false;

        while(true && num < 1000000000) {

            fastBreak = false;
            for(int i = 1; i <= 20; i++) {
                if(num % i != 0) {
                    fastBreak = true;
                    break;
                }
            }
            if(!fastBreak) {
                return num;
            }
            num++;
        }
        return num;

    }
}
