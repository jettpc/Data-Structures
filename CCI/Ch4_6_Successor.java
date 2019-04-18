package CCI;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent
 */

public class Ch4_6_Successor {

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

    public static void main(String args[]) {
        Node tree = new Node(4);
        tree.left = new Node(2);
        tree.right = new Node(5);
        tree.left.left = new Node(1);
        tree.left.right = new Node(3);

        ArrayList<Integer> arr = inOrder(tree);
        System.out.println(arr.toString());

        int s = successor(arr, 2);
        System.out.println(s);




    }

    public static int successor(ArrayList<Integer> arr, int n) {
        if(n == arr.size() - 1) {
            System.out.println("won't be able to reach next index because you've inputted final node");
            return -1;
        }

        for(int i = 0; i < arr.size() - 1; i++) {
            if(arr.get(i) == n) {
                return arr.get(i+1);
            }
        }

        //should never hit this return
        return Integer.MIN_VALUE;
    }

    public static ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        return inOrderHelper(root, list);
    }

    public static ArrayList<Integer> inOrderHelper(Node root, ArrayList<Integer> list) {
        if(root == null) {
            return null;
        }
        inOrderHelper(root.left, list);
        list.add(root.data);
        inOrderHelper(root.right, list);


        return list;
    }

}
