package CCI;

/**
 * String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than
 * the original string, your method should retrun the original string. You can assume the string has only uppercase
 * and lowercase letters (a-z)
 */

public class Ch1_6_StringCompression {

//    public static void main(String args[]) {
//        String s = "aabcccccaaa";
//        System.out.println(compress(s));
//    }

    /**
     * compressed the string based on the above algorithm
     * @param originalString
     * @return the compressed string or the original string, depending on which is shorter.
     */
    //the concatenation operates in O(n^2). We can fix this using a StringBuilder and finding the final length first
    public String compress(String originalString) {
        /*check final length and return input string if final length > input string length */
        int compressedLength = calcCompressedLength(originalString);
        if(compressedLength >= originalString.length()) return originalString;

        StringBuilder compressed = new StringBuilder(compressedLength); //initial compacity
        int consecutiveCounter = 0;

        for(int i = 0; i < originalString.length(); i++) {
            consecutiveCounter++;
            if(i + 1 >= originalString.length() || originalString.charAt(i) != originalString.charAt(i+1)) {
                compressed.append(originalString.charAt(i)).append(consecutiveCounter);
                consecutiveCounter = 0;
            }
        }
        return compressed.toString();
    }

    /**
     * Calculates the length of the compressed string to compare against the orignal string
     * if the "compressed" length is longer, we don't need to execute the code to generate
     * a compressed string
     * @param originalString
     * @return length of compressed string
     */
    public int calcCompressedLength(String originalString) {
        int compressedLength = 0;
        int consecutiveCount = 0;
        for(int i = 0; i < originalString.length(); i++) {
            consecutiveCount++;
            //if the current character != current character + 1
            if(i + 1 >= originalString.length() || originalString.charAt(i) != originalString.charAt(i+1)) {
                //1 is for the letter, String.valueOf trick is for if the consecutive counter > 1 digit
                compressedLength += 1 + String.valueOf(consecutiveCount).length();
                consecutiveCount = 0;
            }
        }
        return compressedLength;
    }
}
