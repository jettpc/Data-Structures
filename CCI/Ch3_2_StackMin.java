package CCI;

public class Ch3_2_StackMin {

    public static class StackWithMin2 extends Ch3_MyStack {
        Ch3_MyStack minStack;
        public StackWithMin2 () {
            minStack = new Ch3_MyStack();
        }

        public void push(int value) {
            if(value <= min()) {
                //if value is smaller or equal, push it on the minStack stack
                minStack.push(value);
            }
            //either way, push it to the super stack
            super.push(value);
        }

        public int pop() {
            int value = super.pop();
            if(value == min()) {
                //if value is equal to a value on the min stack, pop the item off the min stack
                minStack.pop();
            }
            return value;
        }

        //returns min - the top of the stackwithmin2 stack
        public int min() {
            if(minStack.isEmpty()) {
                System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
                return Integer.MAX_VALUE;
            } else {
                return minStack.peek();
            }
        }

    }


    public static void main(String args[]){
        StackWithMin2 myMinStack = new StackWithMin2();
        myMinStack.push(105);
        myMinStack.push(110);
        myMinStack.push(5);
        myMinStack.push(110);


        System.out.println(myMinStack.min());



        myMinStack.printStack();
    }
}
