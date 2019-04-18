package CCI;
//Given two strings, write a method to decide if one is a permutation of the other.
public class Ch1_2_CheckPermutation {

//    public static void main(String args[]) {
//        String s = "asdf";
//        String s1 = "fdsa";
//        System.out.println(permutation2(s,s1));
//    }

    //solution 1: sort the strings and check if the strings are equal
    public boolean permutation(String s1, String s2) {
        //check length first
        if(s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }

    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }
    //solution 2: check two strings have identical character counts using a "hash table" like data structure
    //use an array of integers of size 128. Add 1 for every character you find at that ASCII location, subtract 1
    //when comparing with the secondary array. The final array should be all 0's if they are equal.

    public boolean permutation2(String s1, String s2) {

        //permutation: the act of arranging ALL members of a set into some sequence or order.
        if(s1.length() != s2.length()) {
            return false;
        }

        int[] freq = new int[128];
        int ascii;

        for(int i = 0; i < s1.length(); i++) {
            ascii = s1.charAt(i); //parsing char to int will give ascii value
            //System.out.println(ascii);
            freq[ascii]++;
        }

        for(int i = 0; i < s2.length(); i++) {
            ascii = s2.charAt(i);
            freq[ascii]--;
            if(freq[ascii] < 0) { //if there was an unequal number of occurances of a given char
                return false;
            }
        }

        return true; //no negative values, all counts add up
    }

    //Given two strings, write a method to decide if one is a permutation of the other.
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }
}
