package CCI;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 */

public class Ch4_2_MinimalTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = new int[]{0, 1, 2, 3, 4, 5, 6};
        int n = arr.length;
        tree.root = sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        preOrder(tree.root);
    }

    /* A utility function to print preorder traversal of BST */
    static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        System.out.print(node.data + " ");
        preOrder(node.right);
    }

    static class BinaryTree {
        Node root;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
            left = null;
            right = null;
        }
    }

    static Node sortedArrayToBST(int[] arr, int start, int end) {
        //base case
        if(start > end) {
            return null;
        }

        //1. create node at middle
        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);

        //2. assign left subtree to recurse (left subtree)
        n.left = sortedArrayToBST(arr, start, mid - 1);

        //3. assign right subtree to recurse (right subtree)
        n.right = sortedArrayToBST(arr, mid + 1, end);

        //4. return node at middle
        return n;
    }










































//
//    /* A function that constructs Balanced Binary Search Tree
//    from a sorted array */
//    static Node sortedArrayToBST(int arr[], int start, int end) {
//
//        /* Base Case */
//        if (start > end) {
//            return null;
//        }
//
//        /* Get the middle element and make it root */
//        int mid = (start + end) / 2;
//        Node node = new Node(arr[mid]);
//
//		/* Recursively construct the left subtree and make it
//		left child of root */
//        node.left = sortedArrayToBST(arr, start, mid - 1);
//
//		/* Recursively construct the right subtree and make it
//		right child of root */
//        node.right = sortedArrayToBST(arr, mid + 1, end);
//
//        return node;
//    }
//
//    // A binary tree node
//    static class Node {
//        int data;
//        Node left, right;
//
//        Node(int d) {
//            data = d;
//            left = right = null;
//        }
//    } //class node
//
//    static class BinaryTree {
//        static Node root;
//    } //class binary Tree

} //class Ch4_2_MinimalTree
