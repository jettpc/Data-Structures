package Euler;

public class P14_Longest_Collatz_sequence {

    /**
     * The following iterative sequence is defined for the set of positive integers:
     *
     * n → n/2 (n is even)
     * n → 3n + 1 (n is odd)
     *
     * Using the rule above and starting with 13, we generate the following sequence:
     *
     * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
     * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
     *
     * Which starting number, under one million, produces the longest chain?
     *
     * NOTE: Once the chain starts the terms are allowed to go above one million.
     */

    public static void main(String[] args) {
        long answer = longestChain();
        System.out.println(answer);
    }

    public static long longestChain() {
        long longestChainIndex = 0;
        long longestChain = 0;
        long sequence = 0;
        for(int i = 1; i < 1000000; i++) {
            int cLength = 1;
            sequence = i;
            while(sequence != 1) {
                if(sequence % 2 == 0) {//even
                    sequence = sequence / 2;
                }
                else { //odd
                    sequence = sequence * 3 + 1;
                }
                cLength++;
            }
            if(cLength > longestChain) {
                longestChain = cLength;
                longestChainIndex = i;
            }
        }
        return longestChainIndex;
    }
}
