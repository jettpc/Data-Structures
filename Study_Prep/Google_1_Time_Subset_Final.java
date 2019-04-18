package Study_Prep;

public class Google_1_Time_Subset_Final {
    // you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


    class Solution {
        public String solution(String S) {

            // Paul Jett - thanks again for your time
            if(S.charAt(0) > '2' || S.charAt(1) > '3' || S.charAt(3) > '5' || S.length() != 5 || !S.contains(":")) {
                return "invalid time";
            }

            //first half
            char one = S.charAt(0);
            char two = S.charAt(1);

            StringBuilder sb = new StringBuilder();

            if(one < two) {
                //replace second with first
                for(int i = 0; i < 2; i++) {
                    sb.append(one);
                }
            } else {
                //replace first with second
                for(int i = 0; i < 2; i++) {
                    sb.append(two);
                }
            }
            sb.append(":");

            //second half
            char three = S.charAt(3);
            char four = S.charAt(4);

            if(three < four) {
                //replace second with first
                for(int i = 0; i < 2; i++) {
                    sb.append(three);
                }
            } else {
                //replace first with second
                for(int i = 0; i < 2; i++) {
                    sb.append(four);
                }
            }

            return sb.toString();
        }
    }
}
