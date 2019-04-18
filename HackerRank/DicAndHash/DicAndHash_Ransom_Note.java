package HackerRank.DicAndHash;

import java.util.Hashtable;

public class DicAndHash_Ransom_Note {

    //case-sensitive words
    //cannnot use substrings or concatenation to create words he needs

    public static void main(String[] args) {
        String[] m = {"give","me","one","grand","today","night"};
        String[] n = {"give","one","grand","today"};
        checkMagazine(m,n);
    }

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer> magTracker = new Hashtable<String, Integer>();

        //add all words from magazine to magTracker
        for(String s : magazine) {
            if(magTracker.containsKey(s)) {
                magTracker.put(s, magTracker.get(s) + 1); //add one to integer value if there are duplicates
            } else {
                magTracker.put(s,1);
            }
        }

        //check if magTracker has all the words necessary in the ransom note
        for(String s : note) {
            if(!magTracker.containsKey(s)) { //not found
                System.out.println("No");
                return;
            } else { //if it is found!
                if(magTracker.get(s) > 1) { //decrement if above 1
                    magTracker.put(s, magTracker.get(s) - 1);
                } else { //remove if just 1
                    magTracker.remove(s);
                }
            }
        }
        System.out.println("Yes");
    }
}
