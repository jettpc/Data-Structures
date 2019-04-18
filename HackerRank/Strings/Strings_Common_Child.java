package HackerRank.Strings;

import java.util.Arrays;
import java.util.HashSet;

public class Strings_Common_Child {

    public static void main(String[] args) {
        String s1 = "HARRY";
        String s2 = "SALLY";

        System.out.println(commonChild(s1,s2));
    }
    // Complete the commonChild function below.
    static int commonChild(String a, String b) {
        int[][] C = new int[a.length()+1][b.length()+1];



        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {

                    System.out.println(i + " " + j);
                    C[i+1][j+1] = C[i][j] + 1;
                    for(int K = 0; K < C.length; K++) {
                        System.out.println(Arrays.toString(C[K]));
                    }
                } else {
                    System.out.println("not equal " + i + " " + j);
                    C[i+1][j+1] = Math.max(C[i+1][j], C[i][j+1]);
                    for(int K = 0; K < C.length; K++) {
                        System.out.println(Arrays.toString(C[K]));
                    }
                }
            }
        }

        return C[a.length()][b.length()];
    }
}
