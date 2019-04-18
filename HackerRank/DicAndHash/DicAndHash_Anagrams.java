package HackerRank.DicAndHash;

import java.util.Hashtable;
import java.util.LinkedList;

public class DicAndHash_Anagrams {

    public static void main(String[] args) {
        String s = "kkkk";
        System.out.println(sherlockAndAnagrams(s));
        System.out.println(s.substring(0,1));
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        //brute force compute every substring organize in a table by <length of Substring, substring>
        Hashtable<Integer, LinkedList<String>> allSubs = createAllSubstrings(s);
        //if a pair exists at each key, remove the pair and add one to anagram count
        LinkedList<String> temp;
        int totalAnagrams = 0;
        System.out.println(allSubs.toString());
        for(int i = 1; i <= s.length(); i++) { //check every key value
            if(allSubs.containsKey(i)) {
                temp = allSubs.get(i);
                totalAnagrams = totalAnagrams + countAnagrams(temp);
            }

        }
        System.out.println(allSubs.toString());
        return totalAnagrams;
    }

    static int countAnagrams(LinkedList<String> list) {
        if(list.size() == 1) {
            return 0;
        }
        int counter = 0;
        String s1;
        String s2;
        boolean match; //flag for signifying no matches throughout the entire iteration
        while(list.size() > 1) {
            s1 = list.getFirst();
            match = false;
            for(int i = 1; i <list.size(); i++) {
                s2 = list.get(i);
                if(anagram(s1,s2)) {
                    counter++;
                }
            }
            list.remove(s1);
        }
        return counter;
    }

    static boolean anagram(String s1, String s2) {
        int[] freqTable = new int[26]; //all lowercase ascii [a-z]
        int a = Character.getNumericValue('a');
        int val;
        for(char c : s1.toCharArray()) {
            val = Character.getNumericValue(c) - a;
            freqTable[val]++;
        }
        for(char c : s2.toCharArray()) {
            val = Character.getNumericValue(c) - a;
            freqTable[val]--;
            if(freqTable[val] < 0) {
                return false;
            }
        }
        return true;
    }

    static Hashtable<Integer, LinkedList<String>> createAllSubstrings(String s) {
        Hashtable<Integer, LinkedList<String>> allSubs = new Hashtable<Integer, LinkedList<String>>();
        int len = s.length();
        String tempS;
        int tempLen;
        LinkedList<String> tempLL;
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                tempS = s.substring(i,j+1);
                tempLen = tempS.length();
                if (allSubs.containsKey(tempLen)) {
                    tempLL = allSubs.get(tempLen);
                    tempLL.add(tempS);
                    allSubs.put(tempLen, tempLL); //update linkedlist of substrings for substrings of key length
                } else { //no key exists
                    tempLL = new LinkedList<String>();
                    tempLL.add(tempS);
                    allSubs.put(tempLen, tempLL);
                }
            }
        }
        return allSubs;
    }
}
