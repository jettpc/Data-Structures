package CCI;

public class Ztesting {

    public static class CustomNode {
        public int data;
        public CustomNode[] children;

        public CustomNode(int data) {
            this.data = data;
        }

    }






    public static void main(String args[]) {
        CustomNode n = new CustomNode(1);
        System.out.println(n.data);
        System.out.println(n.children);

//        int[] test;
//        System.out.println(test);




    }
}
