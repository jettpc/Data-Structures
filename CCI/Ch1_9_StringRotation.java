package CCI;

/**
 * String rotation: Assume you have a method isSubstring which checks if one word is a substring of
 * another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only
 * one call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat");
 */

public class Ch1_9_StringRotation {

    public static void main(String args[]) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isRotation(s1,s2));
    }

    /**
     * creates a string that contains 2 copies of the current string, then performs a sliding
     * window (indexOf != -1) operation to determine if s2 exists in s1.
     * @param s1 original string
     * @param s2 check if s2 exists in s1
     * @return true if s2 exists in s1
     */
    public static boolean isRotation(String s1, String s2) {
        String copyString = "";
        if(s1.length() == s2.length() && s1.length() > 0) {
            copyString = s1 + s1;
            System.out.println(copyString);
            return isSubstring(copyString,s2);
        }
        return false;
    }

    public static boolean isSubstring(String s1, String s2) {
        //indexOf is the magic trick!!!!
        if(s1.indexOf(s2) != -1) {
            return true;
        }
        return false;
    }
}
