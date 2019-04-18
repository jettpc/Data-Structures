package CCI;

import java.util.*;

public class DSMain {

    public static void main(String args[]) {

        //*************************************************************************************************LINKEDLIST
        //*************************************************************************************************LINKEDLIST
        //*************************************************************************************************LINKEDLIST


//        public class LinkedListNode {
//            Node head;
//
//            public LinkedListNode() {
//                System.out.println("Created a LinkedListNode");
//            }
//
//            public static class Node {
//                int data;
//                Node next;
//
//                Node(int d) { //constructor
//                    data = d;
//                    next = null;
//                    System.out.println("Node created with data: " + data);
//                }
//            }

        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);

        //for loop
        for (int i = 0; i < l.size(); i++) {
            System.out.println("LinkedList<Integer> l.get(" + i + "): " + l.get(i));
        }

        //iterator
        Iterator it = l.iterator();
        while (it.hasNext()) {
            System.out.println("Iterator: " + it.next());
        }

        //poll and remove are same thing
        System.out.println("l.poll() : " + l.poll());
        System.out.println("l.remove() : " + l.remove());

        //addAll test
        LinkedList<Integer> ladd = new LinkedList<Integer>();
        ladd.add(11);
        ladd.add(12);
        ladd.add(13);

        l.addAll(ladd);

        //for loop
        for (int i = 0; i < l.size(); i++) {
            System.out.println("LinkedList<Integer> l.get(" + i + "): " + l.get(i));
        }

        //*************************************************************************************************STACKANDQUEUE
        //*************************************************************************************************STACKANDQUEUE
        //*************************************************************************************************STACKANDQUEUE
//        public class Ch3_MyStack {
//            private static class StackNode {
//                private int data;
//                private StackNode next;
//
//                public StackNode (int data) {
//                    this.data = data;
//                }
//            }
//            private StackNode top;

        Stack<Integer> s = new Stack<Integer>();

        s.push(1);
        s.push(2);
        s.push(3);

        //print every element in stack
        // method 1:

        System.out.println("\nHow to print stacks");
        String values = Arrays.toString(s.toArray());
        System.out.println(values);

        // method 2:
        Object[] vals = s.toArray();
        for (Object obj : vals) {
            System.out.print(obj + " ");
        }

        System.out.println("\nHow to print Queues");

        Queue<Integer> q = new LinkedList<Integer>();


        System.out.println("\n\n\n");



        int[] test = new int[5];
        test[0] = 2;
        test[1] = 4;
        test[2] = 6;
        test[3] = 8;
        test[4] = 10;

        System.out.println(generalizedGCD(test));
//
//        int[] test2 = new int[8];
//        test2[0] = 1;
//
//        test2[1] = 1;
//
//        test2[2] = 1;
//
//        test2[3] = 0;
//
//        test2[4] = 1;
//
//        test2[5] = 1;
//
//        test2[6] = 1;
//
//        test2[7] = 1;
//
//        int[] test3 = cellCompete(test2, 2);
//        for(int i = 0; i < test3.length; i++) {
//            System.out.println(test3[i]);
//        }





    }







    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int generalizedGCD(int[] arr) {
        // INSERT YOUR CODE HERE
        //test each number mod every number in array, the number that returns 0 for all is the winner
        int gcd = 1; //if gcd is never set, the result is 1


        for (int i = 0; i < arr.length; i++) {
            boolean passedAll = true;
            int temp = arr[i];

            //loop and mod through each ele in arr, if it ever returns != 0, break
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] % temp != 0) {
                    passedAll = false;
                    break;
                }
            }

            //if all numbers can be % by temp, then set gdc to temp
            if (passedAll == true && gcd < temp) {
                gcd = temp;
            }
        }
        return gcd;
    }


    //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int[] cellCompete(int[] cells, int days) {


        int cellSize = cells.length;

        //keep a temp array with the cell representation at the end of the day
        int[] endOfDay = new int[cellSize];
        //set all cells to active and change them after evaluating cells array of current day
        for (int i = 0; i < cellSize; i++) {
            endOfDay[i] = 0;
        }

        //iterate for however many days there are and update endOfDay array as NEEDED
        for (int i = 0; i < days; i++) {

            for(int p = 0; p < cellSize; p++) {
                System.out.print(cells[p] + " ");
            }
            System.out.println();

            //for all the middle cells
            for (int j = 1; j < cellSize - 1; j++) {
                //if left and right cells are both inactive, or both active update endOfDay
                if (cells[j - 1] == 0 && cells[j + 1] == 0 || cells[j - 1] == 1 && cells[j + 1] == 1) {
                    endOfDay[j] = 0;
                } else {
                    endOfDay[j] = 1;
                }
            }

            //after the endOfDay is updated, set cells to endOfDay and reset endOfDay
            for (int l = 0; l < cellSize; l++) {
                cells[l] = endOfDay[l];
            }


            //set all cells to active and change them after evaluating cells array of current day
            for (int k = 0; k < cellSize; k++) {
                endOfDay[k] = 0;
            }

        }

        return cells;


    }


























//THIS SOLUTION WORKS - LENGTHY THOUGH

    // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
//    public class Colony
//    {
//        //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
//        public static int[] cellCompete(int[] cells, int days)
//        {
//            // INSERT YOUR CODE HERE
//            //copy all data from current array to an array that will store update information
//            int cellSize = cells.length;
//
//            int[] updateMe = new int[cellSize + 2];
//
//            for(int i = 1; i <= cellSize; i++) {
//                updateMe[i] = cells[i - 1];
//            }
//
//            //updateMe is now a copy of cellsize with 2 extra spaces for the forever 0's at the ends
//            int[] proxyCells = new int[updateMe.length];
//            //copy everything into the proxy cells
//            for(int i = 0; i < proxyCells.length; i++ ) {
//                proxyCells[i] = updateMe[i];
//            }
//
//            //iterate for every day
//            for(int i = 0; i < days; i++ ){
//
//                //simulates a day
//                for(int j = 1; j < proxyCells.length - 1; j++) {
//                    //if both neighbors are active or inactive
//                    if(proxyCells[j-1] == proxyCells[j+1]) {
//                        updateMe[j] = 0;
//                    } else {
//                        updateMe[j] = 1;
//                    }
//                }
//
//                //after one day, ends will never be 1;
//                updateMe[0] = 0;
//                updateMe[updateMe.length-1] = 0;
//
//                //after the day is over, copy updateMe to cells
//                for(int k = 0; k < proxyCells.length; k++) {
//                    proxyCells[k] = updateMe[k];
//                }
//
//                //after the day is over, fill in cells with whats new
//                for(int p = 0; p < cellSize; p++) {
//                    cells[p] = proxyCells[p+1];
//                }
//
//
//            }
//
//            return cells;
//
//
//
//        }
//        // METHOD SIGNATURE ENDS
//    }























}