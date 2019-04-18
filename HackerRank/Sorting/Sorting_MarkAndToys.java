package HackerRank.Sorting;

import java.util.Arrays;

public class Sorting_MarkAndToys {

    //This solution is n log n, using dynamic programming another solution could be
    public static void main(String[] args) {
        //1 12 5 111 200 1000 10
        int[] test = {1,12,5,111,200,1000,10};
        int k = 50;
        System.out.println(maximumToys(test,k));
    }

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        //sort
        Arrays.sort(prices);
        int toyCount = 0;
        //subtract from price k we iterate
        for(int toy : prices) {
            if(toy <= k) {
                k -= toy;
                toyCount++;
            } else {
                return toyCount;
            }
        }
        return toyCount;
    }

}
