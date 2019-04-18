package HackerRank.WUC;

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * Lilah has a string, , of lowercase English letters that she repeated infinitely many times.
 *
 * Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.
 *
 * For example, if the string  and , the substring we consider is , the first  characters of her infinite string. There are  occurrences of a in the substring.
 *
 * Function Description
 *
 * Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length  in the infinitely repeating string.
 *
 * repeatedString has the following parameter(s):
 *
 * s: a string to repeat
 * n: the number of characters to consider
 * Input Format
 *
 * The first line contains a single string, .
 * The second line contains an integer, .
 *
 * Constraints
 *
 * For  of the test cases, .
 * Output Format
 *
 * Print a single integer denoting the number of letter a's in the first  letters of the infinite string created by repeating  infinitely many times.
 *
 * Sample Input 0
 *
 * aba
 * 10
 * Sample Output 0
 *
 * 7
 * Explanation 0
 * The first  letters of the infinite string are abaabaabaa. Because there are  a's, we print  on a new line.
 *
 * Sample Input 1
 *
 * a
 * 1000000000000
 * Sample Output 1
 *
 * 1000000000000
 */
public class WUC_Repeated_String {

    public static void main(String[] args) {
        String s = "a";
        long n = 1000000000000L;
        System.out.println(3 % 3);

        System.out.println(2 % 3);
        System.out.println(repeatedString(s,n));
        System.out.printf("%d", repeatedString(s,n));
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
//        long letterCount = 0;
//        int wordIndex = 0;
//        int wordLen = s.length();
//
//        //create the string to iterate over
//        for(long i = 0L; i < n; i++) {
//            if(s.charAt(wordIndex) == 'a') {
//                letterCount++;
//            }
//            wordIndex = (wordIndex + 1) % wordLen;
//        }
//        return letterCount;

        if(n > s.length()) {
            long countAs = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'a') {
                    countAs++;
                }
            }

            long remainder = n % s.length();
            long multVal = n / s.length();
            if(multVal > 1) {
                countAs = countAs * multVal;
            }

            //add the remainder count
            for(int j = 0; j < remainder; j++) {
                if(s.charAt(j) == 'a') {
                    countAs++;
                }
            }

            return countAs;
        } else {
            long countAs = 0;
            for(int i = 0; i < n; i++) {
                if(s.charAt(i) == 'a') {
                    countAs++;
                }
            }
            return countAs;
        }
    }
}
