package HackerRank.Sorting;

public class Sorting_BubbleSort {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        countSwaps(a);
    }

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int counter = 0;
        int n = a.length; //length
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j+1);
                    //swap(a[j], a[j + 1]);
                    counter++;
                }
            }
        }
        int first;
        int last;
        first = a[0];
        last = a[a.length - 1];
        //print swaps function at the end
        System.out.println("Array is sorted in " + counter + " swaps.");
        System.out.println("First Element: " + first);
        System.out.println("Last Element: " + last);
    }

    static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
