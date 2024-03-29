package HackerRank.WUC;

/**
 * Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. During his last hike he took exactly  steps. For every step he took, he noted if it was an uphill, , or a downhill,  step. Gary's hikes start and end at sea level and each step up or down represents a  unit change in altitude. We define the following terms:
 *
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.
 *
 * For example, if Gary's path is , he first enters a valley  units deep. Then he climbs out an up onto a mountain  units high. Finally, he returns to sea level and ends his hike.
 *
 * Function Description
 *
 * Complete the countingValleys function in the editor below. It must return an integer that denotes the number of valleys Gary traversed.
 *
 * countingValleys has the following parameter(s):
 *
 * n: the number of steps Gary takes
 * s: a string describing his path
 * Input Format
 *
 * The first line contains an integer , the number of steps in Gary's hike.
 * The second line contains a single string , of  characters that describe his path.
 *
 * Constraints
 * 2 <= n <= 10^6
 * s[i] ? {UD}
 *
 * Output Format
 *
 * Print a single integer that denotes the number of valleys Gary walked through during his hike.
 *
 * Sample Input
 *
 * 8
 * UDDDUDUU
 * Sample Output
 *
 * 1
 */
public class WUC_Counting_Valleys {

    public static void main(String[] args) {
        int n = 8; //number of steps hiked
        String s = "UDDDUDUU";
        System.out.println(countingValleys(n,s));
    }

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int totalValleys = 0;
        int altitude = 0;
        //if my current altitude is 0, and the next step is down then add one to total valley
        for(char step : s.toCharArray()) {
            if(altitude == 0 && step == 'D') {
                totalValleys++;
            }
            if(step == 'D') {
                altitude--;
            }
            if(step == 'U') {
                altitude++;
            }
        }
        return totalValleys;
    }
    //this was correct!
    //next steps: constraints, reading input from a file, reading input from command line, outputting to a file
}
