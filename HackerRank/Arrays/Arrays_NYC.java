package HackerRank.Arrays;

import java.util.Arrays;

public class Arrays_NYC {

    public static void main(String[] args) {
        int[] q = {1,2,5,3,7,8,6,4};
        int[] p = {2,1,5,3,4};
        minimumBribes(q);
        minimumBribes(p);

    }

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        //remake an array that is intuitive
        int moves = 0;
        int[] easyQ = new int[q.length];
        for(int i = 0; i < easyQ.length; i++) {
            easyQ[i] = q[i] - 1;
        }

        //loop through each person in the Q
        for(int p = 0; p < easyQ.length; p++) {
            if(easyQ[p] - p > 2) {
                System.out.println("Too chaotic");
                return;
            }
            //probably be best to use an array list to insert into a sorted data structure of seen elements. if you've seen 5,7,8 and your number is 6, you just need to know you'd insert at 2 for a list 3 going on 4 long.
            for (int j = Math.max(0, q[p]-2); j < p; j++) {
                if (q[j] > q[p])
                    moves++;
            }
        }
        System.out.println(moves);
    }
}
