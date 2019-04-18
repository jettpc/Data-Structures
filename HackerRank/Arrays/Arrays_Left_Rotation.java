package HackerRank.Arrays;

import java.util.Arrays;

public class Arrays_Left_Rotation {

    public static void main(String[] args) {
        int n = 5; //an array of n integers
        int r = 4; //rotations
        int[] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(rotLeft(a,r)));
    }

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int len = a.length; //5
        //challenge - do it in place, no extra space needed - come back to this
        int[] rotatedArray = new int[len];

        int newIndex;
        for(int i = 0; i < len; i++) {
            newIndex = i - d; //left rotation
            if(newIndex < 0) { //if negative
                newIndex = newIndex + len; //do backward modulus calculation
            }
            rotatedArray[newIndex] = a[i];
        }
        return rotatedArray;
    }
}
