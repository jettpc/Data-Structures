package HackerRank.Arrays;

import java.util.Arrays;

public class Arrays_Min_Swaps {

    public static void main(String[] args) {
        int[] ar = {7,1,3,2,4,5,6};
        System.out.println(minimumSwaps(ar));
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        //go through each element in array, if the element isn't where it belongs, find what should be there and swap it
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != i+1) { //if a number is out of place
                customSwap(arr, i+1);
                count++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return count;
    }

    static void customSwap(int[] arr, int target) {
        int temp;
        for(int i = target-1; i < arr.length; i++) {
            if(arr[i] == target) { //swap
                temp = arr[i];
                arr[i] = arr[target - 1];
                arr[target - 1] = temp;
                return;
            }
        }
    }


}
