package HackerRank.Greedy;

import java.util.Arrays;

public class Greedy_MinAbsDif {
    public static void main(String[] args) {
        //brute force
        int[] test = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};

        System.out.println(minimumAbsoluteDifference(test));
    }

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        //sorting makes it so we only have to check consecutive pairs since if you keep moving away from a sorted value, you'll keep increasing the value between elements
        Arrays.sort(arr);

        int minAbsDif = Integer.MAX_VALUE;
        int temp;
        int l = 0;
        for(int r = 1; r < arr.length; r++) {
            temp = Math.abs(arr[l] - arr[r]);
            if(temp < minAbsDif) {
                minAbsDif = temp;
            }
            l = r;
        }
        return minAbsDif;
    }

}
