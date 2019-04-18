package HackerRank.Strings;

import java.util.Hashtable;

public class Strings_Valid_String {

    public static void main(String[] args) {
        String s = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
        System.out.println(isValid(s));
    }


    // Complete the isValid function below.
    static String isValid(String s) {
        Hashtable<Character, Integer> charFreq = new Hashtable<>(); //frequency of each character

        //store frequency of each character
        for(char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        System.out.println(charFreq);
        //trick is to very carefully insert into a new hashtable mapping frequency of each frequency.
        Hashtable<Integer, Integer> freqCheck = new Hashtable<>();
        boolean usedFix = false;
        for(char key : charFreq.keySet()) {
            int val = charFreq.get(key);
            //always insert the freq of the key.
            freqCheck.put(val, freqCheck.getOrDefault(val, 0) + 1);

            if(freqCheck.size() > 1) { //two different frequencies exist
                System.out.println(freqCheck);
                if(fixIfPossible(freqCheck) && !usedFix) { //if its fixable and was fixed
                    usedFix = true;
                } else {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    //if the difference in KEYS (occurence of the letter) is greater than 1, it is not fixable, otherwise, fix it
    static boolean fixIfPossible(Hashtable<Integer, Integer> freqCheck) {
        int prevKey = -1; //negative frequncy is not possible, meaning this has not been set yet
        for(int key : freqCheck.keySet()) { //loops ONLY twice
            if(prevKey != -1) {
                //check for special case of one character being 1
                if(prevKey == 1 && freqCheck.get(prevKey) == 1 || key == 1 && freqCheck.get(key) == 1) {
                    freqCheck.remove(1);
                    System.out.println("removedKey 1");
                    return true;
                }
                if(Math.abs(prevKey - key) > 1) { //not fixable
                    return false;
                }
                //determine the larger key and fix it
                if(prevKey > key) { //1 away
                    if(freqCheck.get(prevKey) > 1) { //cant remove twice
                        return false;
                    }
                    //if it is 1, just remove it and add one to the current key
                    freqCheck.remove(prevKey);
                    freqCheck.put(key, freqCheck.get(key) + 1);
                } else { //key > prevKey
                    if(freqCheck.get(key) > 1) { //cant remove twice
                        return false;
                    } //if it is 1, just remove it and add to prev key
                    freqCheck.remove(key);
                    freqCheck.put(prevKey, freqCheck.get(prevKey) + 1);
                }
            } else {
                prevKey = key;
            }
        }
        return true;
    }
}
