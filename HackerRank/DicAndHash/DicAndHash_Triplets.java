package HackerRank.DicAndHash;

import java.util.*;

public class DicAndHash_Triplets {

    public static void main(String[] args) {
        List<Long> test = new ArrayList<Long>();
        test.add(1L);
        test.add(2L);
        test.add(2L);
        test.add(4L);

        Map<Long, Long> t2 = new HashMap<>();
        //getOrDefault --> Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
        //System.out.println(t2.getOrDefault())


        System.out.println(countTriplets(test,2));
    }

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        //create a hashtable<value, #of that value> then multiply by r in both directions to see if there is a triplet of indeces for that given value
        Map<Long, Long> t2 = new HashMap<>(); //second number
        Map<Long, Long> t3 = new HashMap<>(); //third number
        long result = 0L;

        for(Long a : arr) {
            result += t3.getOrDefault(a, 0L);
            if (t2.containsKey(a)){ //checks if second number was stored
                //stores third number
                t3.put(a*r, t3.getOrDefault(a*r, 0L) + t2.get(a));
            }
            //stores the second number
            t2.put(a*r, t2.getOrDefault(a*r, 0L) + 1);

            System.out.println("a " + a);
            System.out.println("t2 " + t2.toString());
            System.out.println("t3 " +t3.toString());
            System.out.println("result " + result + "\n");
        }
        return result;
    }
}
