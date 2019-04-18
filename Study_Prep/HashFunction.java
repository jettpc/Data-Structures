package Study_Prep;

import java.util.Arrays;

// Hashing doesn't work very well in situations in which duplicate data is stored causing collisions:
// Linear probing - keep moving + 1 until an open spot is found chaining - Every index in array contains
// an arrayList of all values that hash to that index
//
// Also it isn't good for searching for anything except a specific key. However a Hash Table is a data structure that
// offers fast insertion and searching capabilities.

public class HashFunction {

    public String[] theArray;      //elements are hashed and stored at an index in "theArray"
    public int arraySize;          //size of the array

    //constructor
    public HashFunction(int size) {
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "null"); //todo: new representation of an "empty" index. Possibly change primitive int, to object so null can represent "empty"
    }

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        HashFunction hf = new HashFunction(5);

        String[] elements = { "2", "-1", "2", "2", "2"}; //todo: edge case - string without numbers, or larger than int bounds
        hf.hashFunction(elements, hf.theArray);

        hf.findKey("-1");

        //print theArray
        for(int i = 0; i < hf.arraySize; i++) {
            System.out.println("at position: " + i + " the value is: " + hf.theArray[i]);
        }
    }

    /**
     * Use the hashMe elements values as the "key", hash the key to determine
     * the index in theArray they should be stored. If key hashes to the same
     * index, utilize linear probing.
     * @param hashMe elements being added to theArray
     * @param theArray add hashed element values to array
     */
    public void hashFunction(String[] hashMe, String[] theArray) {

        // check length
        if(hashMe.length > theArray.length) {
            System.out.println("Invalid size! Trying to add: " + hashMe.length + " many elements to an array of length: " + theArray.length);
            return;
        }
        int hashIndex = 0;
        for(int i = 0; i < hashMe.length; i++) {
            hashIndex = Math.abs(Integer.parseInt(hashMe[i]) % 3); // Create an index to store the value
            System.out.println("Modulus-3 Hashed Index = " + hashIndex + " for value " + hashMe[i]);
            for(int j = 0; j < theArray.length; j++) {
                if(theArray[hashIndex] != "null") {
                    hashIndex++;
                    hashIndex = hashIndex % arraySize;
                    System.out.println("Collision Try " + hashIndex + " Instead");
                } else {
                    theArray[hashIndex] = hashMe[i];
                    break;
                }
            }
        }
    }

    /**
     * finds the key, which in this case is simply the hash of the value
     * @param key
     * @return the value at that key, or null if no value exists
     */
    public String findKey(String key) {
        int hashIndex = Math.abs(Integer.parseInt(key) % 3); // Find the keys original hash key
        for(int i = 0; i < theArray.length; i++) {
            if(theArray[hashIndex] == key) {
                System.out.println(key + " was found in index " + hashIndex);
                return theArray[hashIndex];
            }
            hashIndex++; //otherwise check linear probed index
            hashIndex = hashIndex % arraySize; //make sure we loop to index 0, if we get to the end of the array
        }
        System.out.println("no key with value: " + key + ", existed in the hashtable");
        return null;
    }
}