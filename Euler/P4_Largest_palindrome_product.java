package Euler;

public class P4_Largest_palindrome_product {
    /**
     * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
     *
     * Find the largest palindrome made from the product of two 3-digit numbers.
     *
     */
    public static void main(String[] args) {

        int[] answer = palindrome();
        System.out.println("The largest palindrome made from two 3-digit numbers is: " + answer[0] + ". Made from the numbers: " + answer[1] + ", and " + answer[2] + ".");
        //checking to see if it works on the console!!
    }

    /**
     * finds the largest palindrome made from the product of two 3-digit numbers as well as the two 3-digit numbers
     * @return //pal[0] = largest palindrome, pal[1] = 3-digit#1, pal[2] = 3-digit#2
     */
    public static int[] palindrome() {

        int[] pal = new int[3];
        int product;

        for(int i = 100; i < 1000; i++) {
            for(int j = 100; j < 1000; j++) {
                product = i * j;
                if(isPalindrome(product) && product > pal[0]) {
                    pal[0] = product;
                    pal[1] = i;
                    pal[2] = j;
                }
            }
        }
        return pal;
    }

    /**
     * Helper method that checks if int is palindrome - reads the same both ways. ex: 9009, 101
     * @param num is the number being checked
     * @return true if the number is a palindrome, false otherwise
     */
    public static boolean isPalindrome(int num) {
        String s = Integer.toString(num);
        int indexLast = s.length() - 1;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(indexLast)) {
                return false;
            }
            indexLast--;
        }
        return true; //num should be a palindrome
    }
}
