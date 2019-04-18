package CCI;

/**
 * Validate BST: Implement a function to check if a binary tree is a binary search tree
 */

public class Ch4_5_ValidateBST_Incomplete {

    //Java implementation to check if given Binary tree
//is a BST or not

    /* Class containing left and right child of current
    node and key value*/
    static class Node
    {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        Node tree = new Node(4);
        tree.left = new Node(2);
        tree.right = new Node(5);
        tree.left.left = new Node(1);
        tree.left.right = new Node(3);

        if (isBST(tree))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }



    public static boolean isBST(Node n) {
        return isBSTHelper( n, null, null);

    }

    //prove that left <= current < right
    public static boolean isBSTHelper(Node root, Integer min, Integer max) {

        if(root == null) {
            System.out.println("null");
            return true;
        }
        System.out.println("Node: " + root.data + " min: " + min + " max: " + max);
        if((min != null && root.data <= min) || (max != null && root.data > max)) {
            System.out.println("(min != null && root.data <= min) || (max != null && root.data > max)");
            return false;
        }

        if(!isBSTHelper(root.left, min, root.data) || !isBSTHelper(root.right, root.data, max)) {
            System.out.println("!isBSTHelper(root.left, min, root.data) || !isBSTHelper(root.right, root.data, max)");
            return false;
        }
        //should never reach here
        System.out.println("NEVER");
        return true;

    }
}


















//    public static class BinaryTree
//    {
//        //Root of the Binary Tree
//        Node root;
//
//	/* can give min and max value according to your code or
//	can write a function to find min and max value of tree. */
//
//        /* returns true if given search tree is binary
//        search tree (efficient version) */
//        boolean isBST() {
//            return isBSTUtil(root, Integer.MIN_VALUE,
//                    Integer.MAX_VALUE);
//        }
//
//        /* Returns true if the given tree is a BST and its
//        values are >= min and <= max. */
//        boolean isBSTUtil(Node node, int min, int max)
//        {
//            /* an empty tree is BST */
//            if (node == null)
//                return true;
//
//            /* false if this node violates the min/max constraints */
//            if (node.data < min || node.data > max)
//                return false;
//
//		/* otherwise check the subtrees recursively
//		tightening the min/max constraints */
//            // Allow only distinct values
//            return (isBSTUtil(node.left, min, node.data-1) &&
//                    isBSTUtil(node.right, node.data+1, max));
//        }
//
//        /* Driver program to test above functions */
//        public static void main(String args[])
//        {
//            BinaryTree tree = new BinaryTree();
//            tree.root = new Node(4);
//            tree.root.left = new Node(2);
//            tree.root.right = new Node(5);
//            tree.root.left.left = new Node(1);
//            tree.root.left.right = new Node(3);
//
//            if (tree.isBST())
//                System.out.println("IS BST");
//            else
//                System.out.println("Not a BST");
//        }
//    }

