package CCI;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;

/**
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each
 * depth (e.g., if you have a tree with depth D, you'll have D linked lists.
 */

public class Ch4_3_ListOfDepths {

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

        n.left.left.left = new Node(6);

        ArrayList<LinkedList<Node>> dList = createDepthList(n);
        for(LinkedList<Node> list : dList) {
            for(Node nod : list) {
                System.out.print(nod.data);
            }
            System.out.println();
        }
        System.out.println(dList.toString());
    }

    public static ArrayList<LinkedList<Node>> createDepthList(Node root) {
        ArrayList<LinkedList<Node>> depthList = new ArrayList<LinkedList<Node>>();
        depthList(root, depthList, 0);
        return depthList;
    }

    //modify the lists to include all the nodes at the given level
    public static void depthList(Node current, ArrayList<LinkedList<Node>> lists, int level) {
        //base case
        if(current == null) {
            return;
        }

        LinkedList<Node> addMe;
        if(lists.size() == level) { //this means the level hasn't been created
            //create a new linkedList to represent the new level, add it to the list
            addMe = new LinkedList<Node>();
            lists.add(addMe); //size of lists only grows if the level doesn't exist!
        } else {
            addMe = lists.get(level);
        }
        addMe.add(current);

        depthList(current.left, lists, level + 1);
        depthList(current.right, lists, level + 1);
    }
}
