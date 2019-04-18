package CCI;

import java.util.EmptyStackException;

public class Ch3_MyStack {
    private static class StackNode {
        private int data;
        private StackNode next;

        public StackNode (int data) {
            this.data = data;
        }
    }
    private StackNode top;

    //pop(): remove the top item from the stack
    public int pop() {
        if(top == null) throw new EmptyStackException();
        int item = top.data;
        top = top.next;
        return item;
    }

    //push(item): Add an item to the top of the stack
    public void push(int item) {
        StackNode newTopNode = new StackNode(item);
        newTopNode.next = top;
        top = newTopNode;
    }

    //peek(): Return the top of the stack.
    public int peek() {
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    //isEmpty(): Return true if and only if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    //print stack
    public void printStack() {
        StackNode temp = top;
        int index = 0;
        System.out.println("Top of stack is here");
        while(temp != null) {
            System.out.println("SN ID: " + index + " StackNode.data = " + temp.data);
            index++;
            temp = temp.next;
        }
        System.out.println("Bottom of stack is here");
    }

    public static void main(String args[]) {
        System.out.println("hello new discovery");
        Ch3_MyStack myStack = new Ch3_MyStack();

        myStack.push(5);
        myStack.push(10);
        myStack.push(15);
        myStack.push(20);
        myStack.push(25);

        myStack.printStack();
    }
}