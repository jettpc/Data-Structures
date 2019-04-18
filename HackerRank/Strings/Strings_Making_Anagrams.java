package HackerRank.Strings;

public class Strings_Making_Anagrams {

    public static void main(String[] args) {
        String s1 = "cde";
        String s2 = "abc";
        System.out.println(makeAnagram(s1,s2));
    }

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int[] freqTable = new int[26];
        int result = 0;
        for(char c : a.toCharArray()) {
            freqTable[c-'a']++;
        }
        for(char c : b.toCharArray()) {
            freqTable[c-'a']--;
        }
        for(int i : freqTable) {
            result += Math.abs(i);
        }
        return result;
    }
}
