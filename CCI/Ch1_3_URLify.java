package CCI;

public class Ch1_3_URLify {
    /**write a method to replace all spaces in a string with '%20'. You may assume that the string
     * has sufficient space at the end to hold additional characters, and that you are given the "true" length
     * of the string. (if Java, use character array to perform this operation in place.)
     */

//    public static void main(String args[]) {
//        //not sure what "true length of the string" means
//
//        String s = "Mr John Smith    ";
//        char[] str = s.toCharArray();
//        int trueLength = 13;
//
//        //replaceSpaces(str,trueLength);
//        System.out.println(str);
//        System.out.println(s);
//    }

    public void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i;
        System.out.println(str.length);

        //Iterate through the char array from left to right, counting spaces, stopping at "true" length of string
        for(i = 0; i < trueLength; i++) {
            if(str[i] == ' ') {
                spaceCount++;
            }
        }
        //only times 2 since trueLength already accounts for spaces in the string
        index = trueLength + spaceCount * 2;

        for(i = trueLength - 1; i >= 0; i--) {

            if(str[i] == ' ') {
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
            System.out.print("iteration: " + i + "\t");
            System.out.println(str);
        }
    }
}
