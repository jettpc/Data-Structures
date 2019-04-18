package CCI;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and
 * should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop() should
 * return the same values as it would if there were just a single stack
 */

public class Ch3_3_StackOfPlates {

    static class SetOfStacks {
        ArrayList<Stack> stacks = new ArrayList<Stack>();
        public int capacity; //when the number of nodes in the stack reaches a certain capacity.
        public SetOfStacks(int cap) { //constructor
            this.capacity = cap;
        }

        public void push(int v) {
            Stack<Integer> last = getLastStack();
            if(last != null && !isFull()) {
                last.push(v);
            } else { //must create a new stack
                Stack stack = new Stack();
                stack.push(v);
                stacks.add(stack);
            }
        }

        public int pop() {
            Stack<Integer> last = getLastStack();
            if(last == null) throw new EmptyStackException();
            int v = last.pop();
            if(last.size() == 0) stacks.remove(stacks.size() - 1);
            return v;
        }

        public Stack<Integer> getLastStack() {
            if(stacks.size() == 0) return null;
            return stacks.get(stacks.size() - 1);
        }

        //returns true if the current stack is over capacity
        public boolean isFull() {
            return capacity == getLastStack().size();
        }

        public void printAllStacks() {
            int stackSize = stacks.size();
            if(stackSize == 0) {
                System.out.println("StackSize == 0, nothing in the SetOfStacks");
                return;
            }
            Stack s; //stack size 3: 0, 1, 2 are valid
            Object[] array;
            for(int i = 0; i < stackSize; i++ ) {   //loop for array list of stacks
                s = stacks.get(i);
                array = s.toArray();
                for(int j = 0; j < array.length; j++) {
                    System.out.println("Stack: " + i + " Node: " + array[j]);
                }
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {

        SetOfStacks s = new SetOfStacks(3);

        s.push(5);
        s.push(10);
        s.push(5);
        s.push(105);
        s.push(105);
        s.push(105);
        s.push(205);
        s.push(210);

        s.printAllStacks();


    }

}
