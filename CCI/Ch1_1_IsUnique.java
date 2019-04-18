package CCI;

/**
 * Author: Paul Jett
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */

public class Ch1_1_IsUnique {

    //solution 1: store any existing numbers ASCII code index as true, return false if already true
    public boolean isUniqueChars(String s) {
        if(s.length() > 128) return false;
        boolean[] char_set = new boolean[128];
        int val;
        for(char c : s.toCharArray()) {
            val = c;
            if(char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        //empty.
        return true;
//        for(int i = 0; i < s.length(); i++) {
//            int val = s.charAt(i);
//            //System.out.println(val);
//            if(char_set[val]) {
//                return false;
//            }
//            char_set[val] = true;
//        }
//        return true;
    }

    //solution 2: sort the string and check if any of the neighbors are the same
    public boolean isUnique(String s) {
        if(s.length() > 128) return false;
        //sort the string
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        //check neighbors for similar letters
        for(int i = 0; i < s.length() - 1; i++) {
            if(content[i] == content[i+1]) {
                return false;
            }
        }
        return true;
    }
}
