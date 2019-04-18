package CCI;

import java.util.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top. You can use an additional
 * temporary stack, but you may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and isEmpty
 */

public class Ch3_5_SortStack {

    public static void main(String args[]) {
        System.out.println("right here bb");
        Stack n = new Stack();
        n.add(100);
        n.add(101);
        n.add(1);
        n.add(102);

        System.out.println(n.toString());

        sort(n);

        System.out.println(n.toString());
    }

    public static void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();

        System.out.println(r);
        System.out.println(r.isEmpty());

        while(!s.isEmpty()) { //while s isnt empty
            /* Insert each element in s in sorted order into r. */
            int tmp = s.pop(); //pop s
            while(!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }

        /* Copy the elements from r back into s */
        while(!r.isEmpty()) {
            s.push(r.pop());
        }
    }


}
