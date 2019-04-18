package HackerRank.DicAndHash;

import java.util.HashSet;

public class DicAndHash_Two_Strings {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        System.out.println(twoStrings(s1,s2));
    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        //place each letter of s1 into a hashtable, hashset, or dictionary.
        //if any letter in s2 is contained in s1, report yes, otherwise, no
        HashSet<Character> letters = new HashSet<Character>();
        for(char c : s1.toCharArray()) {
            letters.add(c);
        }

        for(char c : s2.toCharArray()) {
            if(letters.contains(c)) { //if s2 contains any letter from s1, return yes
                return "YES";
            }
        }
        return "NO";
    }

}
