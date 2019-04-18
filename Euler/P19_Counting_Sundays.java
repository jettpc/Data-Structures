package Euler;

public class P19_Counting_Sundays {

    /**
     * You are given the following information, but you may prefer to do some research for yourself.
     *
     * 1 Jan 1900 was a Monday.
     * Thirty days has September,
     * April, June and November.
     * All the rest have thirty-one,
     * Saving February alone,
     * Which has twenty-eight, rain or shine.
     * And on leap years, twenty-nine.
     * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
     * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
     */

    public static void main(String args[]) {
        int answer = countingSundays();
        System.out.println(answer);
    }

    public static int countingSundays() {
        //30 days = Sept, April, June, November
        //31 days = January, March, May, July, August, October, December
        //28 days = Feb *** except on a fancy leap year ***
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        int sunday = 6; // January 1901 - 6th day of the month was a sunday;
        int sCount = 0;
        int year = 1901;

        for(int j = year; j <= 2000; j++) {
            if(year % 4 == 0 && year % 400 != 0) { //leap year
                months[1] = 29;
            }
            else {
                months[1] = 28;
            }
            for(int i = 0; i < months.length; i++) { //each month
                while(sunday < months[i]) {
                    sunday += 7;
                }
                sunday %= months[i];
                if(sunday == 1) {
                    sCount++;
                }
            }
        }
        return sCount;
    }
}
