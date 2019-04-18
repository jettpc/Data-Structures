package CCI;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a
 * word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words
 */

public class Ch1_4_PalindromePermutation {

//    public static void main(String args[]) {
//        String s = "Taco cat";
//        System.out.println(isPermutationOfPalindrome(s));
//    }

    /**
     * Check if the inputted string is a valid permutation of a palindrome!
     * @param s - inputted string
     * @return true if it's a valid permutation
     */
    public boolean isPermutationOfPalindrome(String s) {
       int[] table = buildCharFrequencyTable(s);
       return checkMaxOneOdd(table);
    }

    /**
     * make sure only 1 odd number exists
     * @param table
     * @return true if 0 or 1 characters only have an odd number - valid palindrome will only have 1 odd character count
     */
    public boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for(int charIndex : table) {
            if(table[charIndex] % 2 == 1) {
                if(foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /**
     * Map each character to a number (a-->0, b-->1 ...
     * @param c
     * @return the index of the mapped character or -1 if the char isn't equal to or between a and z
     */
    public int mapCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(val >= a && val <= z) {
            return val - a;
        }
        return -1;
    }

    /**
     * Builds a character frequency table. Ex: index 0 (a) holds 2 a's so table[0] = 2
     * @param s inputted string generating a character frequency table of
     * @return int[] the frequency table!
     */
    public int[] buildCharFrequencyTable(String s) {
        //create table that will be returned
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        //map count of each valid char to it
        int mappedVal = 0;
        for(Character c: s.toCharArray()) {
            mappedVal = mapCharNumber(c);
            if(mappedVal != -1) {
                table[mappedVal]++;
            }
        }
        return table;
    }

}
