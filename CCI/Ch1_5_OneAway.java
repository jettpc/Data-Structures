package CCI;

/**
 * There are three types of edits that can be performed on strings:
 * insert a character,
 * remove a character,
 * replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 *
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 */


public class Ch1_5_OneAway {

//    public static void main(String args[]) {
//        String s1 = "12345";
//        String s2 = "123450";
//
//        System.out.println(oneEditAway(s1,s2));
//    }

    /**
     * determines if the two inputted strings are one insert, delete, or replace away
     * @param s1 string 1
     * @param s2 string 2
     * @return true if the strings are one edit away
     */
    public boolean oneEditAway(String s1, String s2) {
        if(s1.length() == s2.length()) { //check equal length
            return oneReplaceAway(s1,s2);
        } else if(s1.length() + 1 == s2.length()) { //s1 < s2
            return oneInsertAway(s1,s2);
        } else if(s1.length() == s2.length() + 1) { //s2 < s1
            return oneInsertAway(s2,s1);
        }
        return false;
    }

    /**
     * If the lengths are equal, make sure there's only one difference in the string
     * @param s1 string 1
     * @param s2 string 2
     * @return true if there's only 0 or 1 difference in the strings
     */
    public boolean oneReplaceAway(String s1, String s2) {
        boolean flagDifference = false;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(flagDifference) {
                    return false;
                }
                flagDifference = true;
            }
        }
        return true;
    }

    /**
     * If one length is larger than the other, make sure its only one insert or deletion of a difference in the strings
     * @param shorter shorter string
     * @param longer longer string
     * @return true if there's only 1 difference in the strings
     */
    public boolean oneInsertAway(String shorter, String longer) {
        int shorterIndex = 0;
        int longerIndex = 0;

        while(shorterIndex < shorter.length() && longerIndex < longer.length()) {
            if(shorter.charAt(shorterIndex) != longer.charAt(longerIndex)) {
                if (shorterIndex != longerIndex) { //this will be the second time that a difference is found
                    return false;
                }
                longerIndex++;
            } else {
                shorterIndex++;
                longerIndex++;
            }
        }
        return true;
    }


}
