package CCI;

import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks
 */
public class Ch3_4_QueueViaStacks {

    public static class MyQueue {
        public Stack<Integer> newest, oldest;

        public MyQueue() {
            newest = new Stack<Integer>();
            oldest = new Stack<Integer>();
        }

        public void add(int value) {
            newest.push(value);
        }

        private void shiftStacks() {
            if(oldest.isEmpty()) { //this is amazing - only switch all data from one stack to another if you need to use the front of the stack
                while(!newest.isEmpty()) {
                    oldest.push(newest.pop());
                }
            }
        }

        public int remove() {
            shiftStacks();
            return oldest.pop();
        }

        public int peek() {
            shiftStacks();
            return oldest.peek();
        }

        public void printStacks() {
            System.out.println("Newest Stack: " + newest.toString());
            System.out.println("Oldest Stack: " + oldest.toString());
        }
    }

    public static void main(String args[]){
        System.out.println("Hello world 3v4");
        MyQueue q = new MyQueue();

        q.add(1);
        q.add(2);
        q.add(3);

        q.printStacks();

        System.out.println(q.remove());
        System.out.println(q.remove());


        q.add(101);
        q.add(102);
        q.add(103);

        System.out.println(q.remove());
        System.out.println(q.remove());

        q.printStacks();

    }


}
