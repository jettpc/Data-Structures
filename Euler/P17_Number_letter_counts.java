package Euler;

public class P17_Number_letter_counts {

    /**
     * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
     *
     * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
     *
     *
     * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen)
     * contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
     */



    public static void main(String[] args) {
        int answer = numberLetterCount();
        System.out.println(answer);
    }

    public static int numberLetterCount() {
        //no need for anything fancy because you are hard coding a dictionary either way
        int oneToNine = 3 + 3 + 5 + 4 + 4 + 3 + 5 + 5 + 4; //36
        int tenToNineteen = 3 + 6 + 6 + 8 + 8 + 7 + 7 + 9 + 8 + 8; //70
        int twentyToNinetynine = 10*(6 + 6 + 5 + 5 + 5 + 7 + 6 + 6) + 8*36; //748
        int total = 3600 + 9*(854) + 63 + 8910 + 11 + 854;

        return total;
    }
}
