package HackerRank.Strings;

public class Strings_Alt_Characters_AABA {

    public static void main(String[] args) {
        String s = "ABABAB";
        System.out.println(alternatingCharacters(s));
    }

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        StringBuilder sb = new StringBuilder();
        boolean prevChar; //True = A was last seen, false = B was last seen
        if(s.length() < 2) {
            return 0;
        }
        char c;
        c = s.charAt(0);
        if(c == 'A') {
            prevChar = true;
        } else { //constraint said we will only have A and B
            prevChar = false;
        }
        sb.append(c);

        //loop over all starting at the second index, the first index will be treated above
        for(int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            if(prevChar == true && c == 'B') { //if prev char was 'A' and now it's B
                sb.append(c);
            } else if(prevChar == false && c == 'A') { //if prev char was 'B' and now it's A
                sb.append(c);
            }
            if(c == 'A') {
                prevChar = true;
            } else { //constraint said we will only have A and B
                prevChar = false;
            }
        }
        //get the difference in sb length vs true length
        return s.length() - sb.length();
    }
}
