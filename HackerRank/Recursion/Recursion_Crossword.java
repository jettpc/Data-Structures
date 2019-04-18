package HackerRank.Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion_Crossword {
    public static void main(String[] args) {
        String[] crossword =   {"+-++++++++",
                                "+-++++++++",
                                "+-++++++++",
                                "+-----++++",
                                "+-+++-++++",
                                "+-+++-++++",
                                "+++++-++++",
                                "++------++",
                                "+++++-++++",
                                "+++++-++++"};
        String words = "LONDON;DELHI;ICELAND;ANKARA";
        crosswordPuzzle(crossword,words);
    }



    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {
        //create list of all the blank words details
        List<BlankDetails> bdList = generateBlankWordMap(crossword);

        //get all the words
        String[] wordArr = words.split(";");

        //create an array representing indexes
        int[] indexer = new int[wordArr.length];
        for(int i = 0; i < indexer.length; i++) {
            indexer[i] = i;
        }

        //get all possible permutations the words could be in
        ArrayList<int[]> possiblePermutations = permutations(indexer);

        //check validity of permutation
        String[] answer = getValidPerm(crossword, bdList, wordArr, possiblePermutations);

        return answer;
    }

    /**
     * Generates the valid perm indexing based on the indexing provided by the bdList. At this point, we've created
     * a detailed list of all the tiles capable of forming words and we've stored that in the List<BlankDetails> bdList.
     * Now we need to match the words index with the bdList index to get the position the word should be at in the crossword
     * @param crossword - given blank crossword, we'll copy each loop we naively check for validity
     * @param bdList - list of blank word details
     * @param wordArr - all possible words
     * @param possiblePerms - all possible permutations the words could be placed in the x-word.
     * @return
     */
    public static String[] getValidPerm(String[] crossword, List<BlankDetails> bdList, String[] wordArr, ArrayList<int[]> possiblePerms) {
        //for every possible permutation,
        String[] answer = new String[crossword.length];
        for(int[] permutation : possiblePerms) {
            //String[] tempCrossWord = crossword.clone();
            char[][] charCrossWord = charCross(crossword);
            boolean badPerm = false;
            for(int i = 0; i < permutation.length; i++) { //iterate through specified permutation array
                if(!placeWord(charCrossWord, wordArr[i], bdList, permutation[i])) {
                    badPerm = true;
                    break;
                }
            }
            if(!badPerm) { //if you find the permutation, copy the current char[][] into a String[] and win $$$.
                for(int k = 0; k < charCrossWord.length; k++) {
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j < charCrossWord.length; j++) {
                        sb.append(charCrossWord[k][j]);
                    }
                    answer[k] = sb.toString();
                }
                return answer;
            }
        }
        //should never reach here
        return answer;
    }

    public static char[][] charCross(String[] crossword) {
        char[][] charCrossWord =  new char[crossword.length][crossword.length];
        for(int y = 0; y < crossword.length; y++) {
            char[] temp = crossword[y].toCharArray();
            for(int x = 0; x < crossword.length; x++) {
                charCrossWord[y][x] = temp[x];
            }
        }
        return charCrossWord;
    }

    /**
     * Can the given word be placed into the crossword at the bdLists index for any potential word.
     * returns true if we were able to place the word into the bdList blank spot for that index
     * NOTE: this will update the tempCrossWord
     * @return true if we can place the word, false if we can't
     */
    public static boolean placeWord(char[][] charCrossWord, String word, List<BlankDetails> bdList, int permIndex) {
        BlankDetails temp = bdList.get(permIndex);
        //if its a horizontal word
        if(temp.direction == true) {
            //check if length is appropritate
            if(word.length() != temp.length) {
                return false;
            }
            //assuming you have the correct length, see if the word can be inserted
            int wordIndex = 0;
            for(int x = temp.start[0]; x <= temp.end[0]; x++) {
                char c = charCrossWord[temp.start[1]][x];
                if(c == '-' || c == word.charAt(wordIndex)) {
                    //change the current letter
                    charCrossWord[temp.start[1]][x] = word.charAt(wordIndex);
                    wordIndex++;
                } else {
                    return false;
                }

            }
        } else { //vertical word
            if(word.length() != temp.length) {
                return false;
            }
            //assuming you have the correct length, see if the word can be inserted
            int wordIndex = 0;
            for(int y = temp.start[1]; y <= temp.end[1]; y++) {
                char c = charCrossWord[y][temp.start[0]];
                if(c == '-' || c == word.charAt(wordIndex)) {
                    //change the current letter
                    charCrossWord[y][temp.start[0]] = word.charAt(wordIndex);
                    wordIndex++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Generates a list of BlankDetails objects that track each potential blank words starting and
     * ending x,y coordinates as well as size and direction to simplify things later
     * @param crossword
     * @return
     */
    static List<BlankDetails> generateBlankWordMap(String[] crossword) {
        List<BlankDetails> blankDetails = new ArrayList<>();

        int[] startCoordinates = new int[2];
        int[] endCoordinates = new int[2];
        int length = 0;
        boolean direction;

        int crossLen = crossword.length;

        //check for all horizontal words
        for(int y = 0; y < crossLen; y++) {
            for(int x = 0; x < crossLen; x++) {
                if(crossword[y].charAt(x) == '-' && x + 1 < crossLen && crossword[y].charAt(x + 1) == '-') {//found beginning of horizontal word
                    //mark beginning
                    startCoordinates[0] = x;
                    startCoordinates[1] = y;
                    direction = true; //signifies horizontal
                    //avoid duplicates by moving x promptly to the end of the word
                    while(x + 1 < crossLen && crossword[y].charAt(x + 1) == '-') {
                        x++;
                    }
                    //mark ending
                    endCoordinates[0] = x;
                    endCoordinates[1] = y;
                    length = endCoordinates[0] - startCoordinates[0] + 1;
                    //add new blank word details to list
                    blankDetails.add(new BlankDetails(startCoordinates, endCoordinates, length, direction));
                }
            }
        }

        //check for all vertical words - page fault city
        for(int x = 0; x < crossLen; x++) {
            for(int y = 0; y < crossLen; y++) {
                if(crossword[y].charAt(x) == '-' && y + 1 < crossLen && crossword[y + 1].charAt(x) == '-') { //found beginning of vertical word
                    //mark beginning
                    startCoordinates[0] = x;
                    startCoordinates[1] = y;
                    direction = false; //signifies horizontal
                    //avoid duplicates by moving y promptly to the end of the word
                    while(y + 1 < crossLen && crossword[y + 1].charAt(x) == '-') {
                        y++;
                    }
                    //mark ending
                    endCoordinates[0] = x;
                    endCoordinates[1] = y;
                    length = endCoordinates[1] - startCoordinates[1] + 1;
                    //add new blank word details to list
                    blankDetails.add(new BlankDetails(startCoordinates, endCoordinates, length, direction));
                }
            }
        }

        return blankDetails;
    }


    /**
     * Keeps track of blank potential word formations
     */
    private static class BlankDetails {
        private int[] start;
        private int[] end;
        private int length;
        private boolean direction; //true is horizontal, false is vertical

        /**
         * default constructor
         */
        public BlankDetails() {
            this.start = new int[2]; //start[0] = x start coordinate, start[1] = y start coordinate
            this.end = new int[2]; //start[0] = x end coordinate, start[1] = y end coordinate
            this.length = 0;
            this.direction = false; //dummy value set to false, always remember to set this if using bool
        }

        /**
         * overloaded constructor
         * @param s - int[] of start coordinates start[0] = x, start[1] = y
         * @param e - int[] of end coordinates end[0] = x, end[1] = y
         * @param len - length of word
         * @param direction - direction - true = horizontal, false = vertical
         */
        public BlankDetails(int[] s, int[] e, int len, boolean direction) {
            if(s.length != 2 || e.length != 2) {
                System.out.println("No construction, improperly formatted coordinates");
                return;
            }
            this.start = new int[]{s[0], s[1]};
            this.end = new int[]{e[0], e[1]};
            this.length = len;
            this.direction = direction;
        }

        /**
         * prints out the string for visability
         */
        private void printString() {
            System.out.println("start [x , y] : [" + start[0] + " , " + start[1] + "]");
            System.out.println("end [x , y] : [" + end[0] + " , " + end[1] + "]");
            System.out.println("length : " + length);
            System.out.println("direction : " + direction);
        }
    }

    public static ArrayList<int[]> permutations (int[] a) {
        ArrayList<int[]> results = new ArrayList<int[]>();
        permutations(a, 0, results);
        return results;
    }

    private static void permutations(int[] a, int start, ArrayList<int[]> results) {
        if(start >= a.length) { //no letters left to be permuted
            results.add(a.clone()); //clones current a orientation
        } else {
            for(int i = start; i < a.length; i++) {
                swap(a, start, i);
                permutations(a, start + 1, results);
                swap(a, start, i); //backtracking?
            }
        }
    }

    /**
     * basic swap function, given an array, swap two elements in that array
     * @param a - int[] a - the array needing elements swapped!
     * @param i - index 1
     * @param j - index 2
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
