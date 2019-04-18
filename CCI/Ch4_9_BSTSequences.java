package CCI;

/*
    BST Sequences: A binary search tree was created by traversing through an array from left to right and
    inserting each element. Given a binary search tree with distinct elements, print all possible arrays
    that could have led to this tree.
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class Ch4_9_BSTSequences {
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

    public static void main(String args[]) {
        Node n = new Node(50);
        n.left = new Node(20);
        n.right = new Node(60);
        n.left.right = new Node(25);
        n.left.left = new Node(10);
        n.right.right = new Node(70);

        ArrayList<LinkedList<Integer>> test = allSequences(n);

        for(int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i).toString());
        }

    }

    static ArrayList<LinkedList<Integer>> allSequences(Node node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.data);

        /*Recurse on left and right subtrees */
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        /* Weave together each list from the left and right sides. */
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        /* One list is empty. Add remainder to [a cloned] prefix and store result. */
        if( first.size() == 0 || second.size() == 0 ) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        /* recurse with head of first added to the prefix. Removing the head will damage first, so we'll need to put it back where we found it afterwards */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        /* Do the same thing with second, damaging and then restoring list */
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }




}
