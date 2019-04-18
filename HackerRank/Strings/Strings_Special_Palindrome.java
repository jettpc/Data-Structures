package HackerRank.Strings;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class Strings_Special_Palindrome {

    public static void main(String[] args) {
        String s = "abcbaba";
        System.out.println(substrCount(5, s));
    }

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        //two steps, one create double for loop the creates every possible substring.
        //two - check every substring
        LinkedList<String> allSubStrings = new LinkedList<>();
        int len = s.length();
        String subString;
        long counter = 0L;
        for(int i = 0; i < len; i++) {
            for(int j = i+1; j < len+1; j++) {
                //create and check substring here, eliminates need for linkedList
                subString = s.substring(i,j);
                //check if this substring could potentially make a special palindrome
                if(!palindromePotential(subString)) { //if no early break
                    break;
                }
                counter += specialPalindrone(subString);
            }
        }
        return counter;
    }

    static boolean palindromePotential(String s) {
        Hashtable<Character, Integer> charFreq = new Hashtable<>();

        for(char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c,0) + 1);
            if(charFreq.size() > 2) {
                return false;
            }
            //check if existing keys value > 2
            int prevVal = -1;
            for(char key : charFreq.keySet()) {
                if(prevVal != -1) {
                    if(prevVal > 1 && charFreq.get(key) > 1) { //if both frequencies are greater than 1, its a no no
                        return false;
                    }
                } else {
                    prevVal = charFreq.get(key);
                }
            }
        }
        return true;
    }

    //if all characters are the same, or all characters except the middle
    static int specialPalindrone(String s) {
        int len = s.length();
        if(len < 1) {
            return 1;
        }
        char first = s.charAt(0);
        char last = s.charAt(len-1);
        if(first != last) {
            return 0;
        }
        int decrement = s.length() - 1;
        for(int i = 0; i < (s.length() / 2); i++) {
            char front = s.charAt(i);
            char back = s.charAt(decrement);
            if(front != first || back != first) {
                return 0;
            }
            decrement--;
        }
        return 1;
    }
}
