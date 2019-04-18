package HackerRank.WUC;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen
 * Emma is playing a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus  or . She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud. It is always possible to win the game.
 *
 * For each game, Emma will get an array of clouds numbered  if they are safe or  if they must be avoided. For example,  indexed from . The number on each cloud is its index in the list so she must avoid the clouds at indexes  and . She could follow the following two paths:  or . The first path takes jumps while the second takes .
 *
 * Function Description
 *
 * Complete the jumpingOnClouds function in the editor below. It should return the minimum number of jumps required, as an integer.
 *
 * jumpingOnClouds has the following parameter(s):
 *
 * c: an array of binary integers
 * Input Format
 *
 * The first line contains an integer , the total number of clouds. The second line contains  space-separated binary integers describing clouds  where .
 *
 * Constraints
 *
 * Output Format
 *
 * Print the minimum number of jumps needed to win the game.
 *
 * Sample Input 0
 *
 * 7
 * 0 0 1 0 0 1 0
 * Sample Output 0
 *
 * 4
 */

public class WUC_Cloud_Jumping {

    public static void main(String[] args) {
        int n = 6; //number of steps hiked
        int[] c = {0,0,0,0,1,0};
        System.out.println(jumpingOnClouds(c));
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumpCount = 0;
        int arrayIndex = 0;
        int maxLength = c.length; //6 indexed 0-5

        while(arrayIndex < maxLength - 1) {
            if(arrayIndex + 2 >= maxLength || c[arrayIndex+2] == 1) {
                //then only jump one cloud, otherwise jump 2
                arrayIndex++;
                jumpCount++;
            } else {
                arrayIndex = arrayIndex + 2;
                jumpCount++;
            }
        }
        return jumpCount;
    }

    //this was correct!
    //next steps: constraints, reading input from a file, reading input from command line, outputting to a file
    //tricky edge case - add a jump to hit the end, but don't loop again while at the end.
}
