package HackerRank.Arrays;

import java.util.Arrays;

public class Arrays_Manipulation {

    public static void main(String[] args) {
        int n = 10;
        int[][] q = {{1,5,3},{4,8,7},{6,9,1}};
        System.out.println(arrayManipulation(n,q));
    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] computation = new long[n];

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0] - 1; //minus 1 to get the normal index (since a 1-indexed array is an array where 1 is the start instead of 0..
            int b = queries[i][1] - 1; //same as above comment
            int k = queries[i][2];

            computation[a] += k;
            System.out.println(Arrays.toString(computation));
            if (b + 1 < n ) { //this is mind blowing.
                computation[b + 1] -= k;
            }
            System.out.println(Arrays.toString(computation));
        }

        long max = 0; long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += computation[i];
            max = Math.max(max, sum);
        }

        return max;

    }
}
