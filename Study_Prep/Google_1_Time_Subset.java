package Study_Prep;

public class Google_1_Time_Subset {
    public static void main(String[] args) {
        System.out.println("hello");
        /**
         * I am going to use my own IDE since i'm more comfortable debugging in it than this editor.
         * Thanks for your time and consideration thus far, and I hope you're having a good day :D
         */

        String time = "11:01";

        //first half
        char one = time.charAt(0);
        char two = time.charAt(1);

        StringBuilder sb = new StringBuilder();

        if(one < two) {
            //replace second with first/
            for(int i = 0; i < 2; i++) {
                sb.append(one);
            }
        } else {
            //replace first with second
            for(int i = 0; i < 2; i++) {
                sb.append(two);
            }
        }
        sb.append(":");

        //second half
        char three = time.charAt(3);
        char four = time.charAt(4);

        if(three < four) {
            //replace second with first
            for(int i = 0; i < 2; i++) {
                sb.append(three);
            }
        } else {
            //replace first with second
            for(int i = 0; i < 2; i++) {
                sb.append(four);
            }
        }

        System.out.println(sb.toString());

    }
}
