package HackerRank.Arrays;

public class Arrays_2D_Array {

    public static void main(String[] args) {
        int[][] arr = { {1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 4, 4, 0},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0}};
        System.out.println(hourglassSum(arr));
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        //trick to this problem is not going out of bounds - never 2 away from the right, never 2 away from the bottom
        int maxHourGlass = Integer.MIN_VALUE;
        int temp;
        int newLength = arr.length - 2;
        for(int i = 0; i < newLength; i++) {
            for(int j = 0; j < newLength; j++) {
                temp = hourglassCalc(arr, i, j); //row and col order shouldn't matter here
                if(temp > maxHourGlass) {
                    maxHourGlass = temp;
                }
            }
        }
        return maxHourGlass;
    }

    static int hourglassCalc(int[][] arr, int r, int c) {
        int sum = 0;
        //top and bottom row
        for(int i = 0; i < 3; i++) {
            sum = sum + arr[r][c+i];
            sum = sum + arr[r+2][c+i];
        }
        sum = sum + arr[r+1][c+1];
        return sum;
    }
}
