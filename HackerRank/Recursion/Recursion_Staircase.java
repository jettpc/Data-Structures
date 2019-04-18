package HackerRank.Recursion;

import java.util.HashMap;
import java.util.Map;

public class Recursion_Staircase {

    //this is considered a cache?
    //https://www.hackerrank.com/challenges/ctci-recursive-staircase/forum?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking&h_r=next-challenge&h_v=zen
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(stepPerms(1));
    }

    // Complete the stepPerms function below.
    static int stepPerms(int n) {
        if(n < 0)
            return 0;

        if(n == 0)
            return 1;

        //if it's not in the map, calculate and put it in the map.
        if(!map.containsKey(n)) {
            int count = stepPerms(n-1) + stepPerms(n-2) + stepPerms(n-3);
            map.put(n, count);
        }
        //if it is in the map (cached) then retrieve it.
        return map.get(n);

    }
}
