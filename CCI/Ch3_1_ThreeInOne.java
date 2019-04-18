package CCI;

import java.util.EmptyStackException;

public class Ch3_1_ThreeInOne {
    static class FixedMultiStack {
        private int numberOfStacks = 3;
        private int stackCapacity;
        private int[] values;
        private int[] sizes;

        //constructor that takes in stack size (1/3 of array size)
        public FixedMultiStack(int stackSize) {
            stackCapacity = stackSize;          //a single stacks compacity
            values = new int[stackSize * 3];    //allocating space for array size
            sizes = new int[numberOfStacks];    //keep track of each stacks size
        }

        //returns if stack is full or not
        public boolean isFull(int stackNum) {
            return sizes[stackNum] == stackCapacity;
        }

        //returns if specific stack is size 0
        public boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }

        //push value onto stack
        public void push(int stackNum, int value) {
            //check if we have the space for the next element
            if (isFull(stackNum)) {
                System.out.println("Full stack exception");
                throw new NullPointerException();
            }
            // add element and increment size. Add element first to avoid missing 0'th index of each stack
            int topIndex = stackNum * stackCapacity + sizes[stackNum];
            values[topIndex] = value;
            sizes[stackNum]++;
        }

        //pop item from top stack
        public int pop(int stackNum) {
            //make sure there is something to pop
            if(isEmpty(stackNum)){
                throw new EmptyStackException();
            }
            //find the index of top of specific stack
            int topIndex = stackNum * stackCapacity + sizes[stackNum] - 1;
            int topValue = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNum]--;
            return topValue;
        }

        //return top element
        public int peek(int stackNum) {
            //make sure there is something to peek at
            if(isEmpty(stackNum)) {
                throw new EmptyStackException();
            }
            //return value at calculated top index, leave stacks and size as is
            int topIndex = stackNum * stackCapacity + sizes[stackNum] - 1;
            int topValue = values[topIndex];
            return topValue;
        }

        public void printStacks() {
            int stackNum = 0;

            for(int i = 0; i < stackCapacity * 3; i++) {
                if(i % stackCapacity == 0) {
                    stackNum++;
                }
                System.out.println("Stack: " + stackNum + " value: " + values[i]);
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("hi there");
        FixedMultiStack myMultiStack = new FixedMultiStack(3);

        myMultiStack.push(1,20);
        myMultiStack.push(1,21);
        myMultiStack.push(1,22);

        myMultiStack.push(2, 30);
        myMultiStack.push(0, 10);

        myMultiStack.pop(1);
        myMultiStack.pop(1);

        myMultiStack.printStacks();
    }
}
