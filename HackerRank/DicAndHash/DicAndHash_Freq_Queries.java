package HackerRank.DicAndHash;

import java.util.*;

public class DicAndHash_Freq_Queries {

    public static void main(String[] args) {
        List<int[]> test = new ArrayList<>();
        int[] a1 = {1,1};
        int[] a2 = {2,2};
        int[] a3 = {3,2};

        test.add(a1);
        test.add(a2);
        test.add(a3);

        System.out.println(freqQuery(test));
    }

    static List<Integer> freqQuery(List<int[]> queries) {
        final Map<Integer, Integer> valueToFreq = new HashMap<>();
        final Map<Integer, Integer> freqToOccurrence = new HashMap<>();
        final List<Integer> frequencies = new ArrayList<>();

        int key;
        int value;
        Integer oldFreq;
        Integer newFreq;
        Integer oldOccurrence;
        Integer newOccurrence;
        for (int[] query : queries) {
            key = query[0];
            value = query[1];
            if (key == 3) {
                if (value == 0) {
                    frequencies.add(1);
                }
                frequencies.add(freqToOccurrence.get(value) == null ? 0 : 1);
            } else {
                oldFreq = valueToFreq.get(value);
                oldFreq = oldFreq == null ? 0 : oldFreq;
                oldOccurrence = freqToOccurrence.get(oldFreq);
                oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;

                if (key == 1) {
                    newFreq = oldFreq + 1;
                } else {
                    newFreq = oldFreq - 1;
                }
                newOccurrence = freqToOccurrence.get(newFreq);
                newOccurrence = newOccurrence == null ? 0 : newOccurrence;

                if (newFreq < 1) {
                    valueToFreq.remove(value);
                } else {
                    valueToFreq.put(value, newFreq);
                }

                if ((oldOccurrence - 1) < 1) {
                    freqToOccurrence.remove(oldFreq);
                } else {
                    freqToOccurrence.put(oldFreq, oldOccurrence - 1);
                }
                freqToOccurrence.put(newFreq, newOccurrence + 1);
            }
        }
        return frequencies;
    }


//my original solution, that is veryyy slow for lookups in the hashtable, this solution was my idea, someone elses solution though
//    // Complete the freqQuery function below.
//    static List<Integer> freqQuery(List<int[]> queries) {
//        //list to return the 0's and 1's from the 3 request
//        List<Integer> result = new ArrayList<Integer>();
//        Hashtable<Integer, Integer> freqTable = new Hashtable<>();
//
//        for(int[] arr : queries) {
//            //get 0, get 1
//            int t0 = arr[0];
//            int t1 = arr[1];
//            switch(t0) {
//                //insert x in your data structure
//                case 1:
//                    freqTable.put(t1, freqTable.getOrDefault(t1, 0) + 1);
//                    break;
//                //delete one occurence of y from your data structure, if present
//                //if not present, sets this to 0, unecessary to keep space for non existant number though. TODO: fix this.
//                case 2:
//                    freqTable.put(t1, freqTable.getOrDefault(t1, 1) - 1);
//                    break;
//                //check if any integer present whose frequency is exactly z, If yes, print 1 else 0.
//                case 3:
//                    result.add(freqCheck(freqTable, t1));
//                    break;
//                default:
//                    System.out.println("BIG ERROR");
//                    break;
//            }
//        }
//        return result;
//    }
//
//    //idea!! Have the frequency be the key and all the values at the frequency be the list of values.
//    static int freqCheck(Hashtable<Integer, Integer> ft, int z) {
//        for(int key : ft.keySet()) {
//            //if the freq (value) at the specified key matches z, return 1
//            if(ft.get(key) == z) {
//                return 1;
//            }
//        }
//        return 0;
//    }
}
