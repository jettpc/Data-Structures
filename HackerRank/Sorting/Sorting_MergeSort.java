package HackerRank.Sorting;

import java.util.Arrays;

public class Sorting_MergeSort {

    /**
     * elements in array are between 1 <= n <= 10^5 int range
     * values of array elements 1 <= arr[i] <= 10^7 int range
     */
    public static long test = 0;

    public static void main(String[] args) {

        int[] arr = {7,5,3,1};

        mergesort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(test);
    }

    /**
     * Helper method for mergesort
     * @param array - array to be sorted
     */
    public static void mergesort(int[] array) {
        mergesort(array, new int[array.length], 0, array.length - 1);
    }

    /**
     * Recursive method to sort inputted array.
     * @param array - array to be sorted
     * @param temp - temp array to sort into
     * @param l - farthest left index in array
     * @param r - farthest right index in array
     */
    public static void mergesort(int[] array, int[] temp, int l, int r) {
        //check if you're crossing indexes - unable to merge anything
        if(l >= r) {
            return;
        }
        //calculate the middle of the array
        int m = (l + r) / 2;
        mergesort(array, temp, l, m); //sort left
        mergesort(array, temp, m + 1, r); //sort right
        mergeHalves(array, temp, l, r); //merge left and right
    }

    /**
     * merges the left array and the right array in sorted order under the
     * assumption that the left and right sides have already been mergesorted.
     * @param array - initial array
     * @param temp - building this array
     * @param leftStart - left most index
     * @param rightEnd - right most index
     */
    public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd) {
            if(array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }



    // Complete the countInversions function below.
    static long countInversions(int[] arr) {

        return 1;
    }


}
