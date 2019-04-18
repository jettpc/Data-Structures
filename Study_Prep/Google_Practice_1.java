package Study_Prep;

public class Google_Practice_1 {

    public static void main(String[] args) {
        String s = "2-4A0r7-4k";
        String answer = solution(s, 3);
    }
    public static String solution(String S, int K) {
        String newString = S;
        newString = newString.replaceAll("-", "");
        newString = newString.toUpperCase();


        if(K == 0)
            return newString;

        int remainder = newString.length() % K;

        StringBuilder sb = new StringBuilder();

        int counter = 0;

        if(remainder > 0) {
            for(int i = 0; i < remainder; i++) {
                sb.append(newString.charAt(i));
            }
            sb.append("-");
            for(int i = remainder; i < newString.length(); i++) {
                if(counter % K == 0 && counter != 0) {
                    sb.append("-");
                }
                sb.append(newString.charAt(i));
                counter++;
            }
        }

        if(remainder == 0) {
            for(int i = 0; i < newString.length(); i++) {
                if(counter % K == 0 && counter != 0) {
                    sb.append("-");
                }
                sb.append(newString.charAt(i));
                counter++;
            }
        }

        return sb.toString();


    }
}
