package CCI;

/**
 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of this question,
 * a balanced tree is defined to be a tree such that the heights of the two subtrees of any node differ by more than one
 */

public class Ch4_4_CheckBalanced {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public static void main(String args[]) {

        Node n = new Node(1);

        n.left = new Node(2);
        n.right = new Node(3);

        n.left.left = new Node(4);
        n.left.right = new Node(5);

        //n.left.left.left = new Node(6);
        System.out.println(isBalanced(n));

    }



    public static boolean isBalanced(Node root) {
        //base case - if next node is null, return true
        if(root == null) {
            return true;
        }
        int heightDif = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(heightDif) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHeight(Node root) {
        if(root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left) , getHeight(root.right)) + 1;
    }























//    public static boolean isBalanced(Node root) {
//        //returns true if the heights of the two substrees difference isn't greater than 1, otherwise false
//        if (root == null) {
//            return true; //base case
//        }
//        int heightDiff = getHeight(root.left) - getHeight(root.right);
//        System.out.println("Node: " + root.data + " left height: " + getHeight(root.left) + " right height: " + getHeight(root.right) + " dif: " + heightDiff);
//        if(Math.abs(heightDiff) > 1) {
//            return false;
//        } else { //recurse
//            return isBalanced(root.left) && isBalanced(root.right);
//        }
//    }
//
//    public static int getHeight(Node root) {
//        if(root == null) return -1; //base case
//        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
//    }

}
