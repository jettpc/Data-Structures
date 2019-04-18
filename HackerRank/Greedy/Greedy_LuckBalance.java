package HackerRank.Greedy;

import java.util.*;

public class Greedy_LuckBalance {
    public static void main(String[] args) {
        int[][] contests = {{5,1}, {2,1}, {1,1}, {8,1}, {-10,0}, {5,0}};
        int k = 3;

        System.out.println(luckBalance(k, contests));
    }

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        List<Integer> important = new LinkedList<>();
        int luck = 0;

        for(int[] arr : contests) {
            if(arr[1] == 1) {
                if(arr[0] < 0) { //if its negative
                    luck += Math.abs(arr[0]);
                } else {
                    important.add(arr[0]);
                }
            } else { //arr[1] == 0
                luck += Math.abs(arr[0]);
            }
        }
        //only allowed to lose k contests, meaning win all the small contests leading up to the remaining k she can lose to gain luck.
        //find and subtract the smallest contests
        Collections.sort(important);
        while(important.size() > k) {
            luck -= ((LinkedList<Integer>) important).removeFirst();
        }
        //add the rest on as losses to increase luck
        for(int remaining : important) {
            luck += remaining;
        }

        return luck;
    }



}
