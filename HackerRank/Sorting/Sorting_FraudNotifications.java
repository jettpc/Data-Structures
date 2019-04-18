package HackerRank.Sorting;

import java.util.Arrays;

public class Sorting_FraudNotifications {
    /**
     * If the amount spent per day is greater than or equal to 2 x the clients median spending for the trailing number of days, send a notification about fraud.
     */
    public static void main(String[] args) {
        int d = 5;
        int[] expenditure = {2,3,4,2,3,6,8,4,5};

        System.out.println(activityNotifications(expenditure, d));
    }

    static int activityNotifications(int[] expenditure, int d) {
        int notifCounter = 0; //notification counter

        int[] freq_table = new int[201];//new int[201]; //since n had the constraint 0 <= expenditure[i] <= 200, we need index 0 - 200

        //initial values of the frequency table
        for(int i = 0; i < d; i++) {
            freq_table[expenditure[i]]++;
        }

        //check if a notification needs to be made
        for(int i = d; i < expenditure.length; i++) {
            if(expenditure[i] >= calcMean(freq_table, d) * 2) {
                notifCounter++;
            }
            //add and subtract to frequencies
            freq_table[expenditure[i-d]]--;
            freq_table[expenditure[i]]++;
        }
        return notifCounter;
    }

    static double calcMean(int[] freq_table, int d) {
        int medianIndex1 = d/2; //used if odd or even
        if(d % 2 != 0) { //if d is odd, return the middle
            //scanning over frequencies ranging from 0 to 200, when we reach half of d, we have the median
            for(int i = 0; i < freq_table.length; i++) {
                if(freq_table[i] > 0) {
                    medianIndex1 -= freq_table[i];
                    if(medianIndex1 < 0) {
                        return i;
                    }
                }
            }
        } else { //if d is even
            int medianIndex0 = d/2 - 1;
            int valueOfIndex0 = Integer.MAX_VALUE;
            //scanning over frequencies ranging from 0 to 200, returning when we find both middle values we will avg as median.
            for(int i = 0; i < freq_table.length; i++) {
                if(freq_table[i] > 0) {
                    medianIndex1 -= freq_table[i];
                    if(medianIndex0 >= 0) {
                        medianIndex0 -= freq_table[i];
                        valueOfIndex0 = i;
                    }
                    if(medianIndex1 < 0 && medianIndex0 < 0) {
                        return (valueOfIndex0 + i) / 2.0;
                    }
                }
            }
        }
        return 100;
    }






//    static int activityNotifications(int[] expenditure, int d) {
//        int notifCounter = 0; //notification counter
//        for(int i = d; i < expenditure.length; i++) {
//            if(expenditure[d] >= calcMean(Arrays.copyOfRange(expenditure, i - d, i)) * 2) {
//                notifCounter++;
//            }
//        }
//        return notifCounter;
//    }
//
//    static double calcMean(int[] expenditureRange) {
//        Arrays.sort(expenditureRange);
//        //System.out.println(Arrays.toString(expenditureRange));
//        int len = expenditureRange.length;
//        if(len % 2 == 0) { //if it's even
//            //System.out.println("returning: " + expenditureRange[(len / 2) - 1] + expenditureRange[len / 2] /2);
//            return expenditureRange[(len / 2) - 1] + expenditureRange[len / 2] /2;
//        } else {
//            //System.out.println("returning else : " + expenditureRange[len/2]);
//            return expenditureRange[len/2];
//        }
//    }


}
