package Study_Prep;

import java.util.LinkedList;

/**
 * CHALLENGE QUESTION FROM AMAZON!!! Compute the largest avg of all nodes in a tree.
 * Largest avg = current node + subtrees / number of nodes checked
 * 1) given binary tree, return the largest avg
 * 2) given a binary tree, return the node where the largest avg is calculated
 * 2) given an n tree, return the largest avg
 * 4) given an n tree, return the node where the largest avg is calculated
 * what if the nodes
 */
public class AmazonHighestAvgLoad {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int value) {
            this.data = value;
            this.left = this.right = null;
        }
    }

    public static class Nnodes<T> {
        private T data;
        private LinkedList<Nnodes<T>> children;

        public Nnodes(T data) {
            this.data = data;
            this.children = new LinkedList<Nnodes<T>>();
        }
    }

    public static class Tracker {
        double largestAvg;
        int numberOfNodes;
        int sumOfNodes;

        public Tracker() {
            largestAvg = 0.0;
            numberOfNodes = 0;
            sumOfNodes = 0;
        }
    }

    public static void main(String[] args) {
//        Node root = new Node(12);
//        root.left = new Node(2);
//        root.right = new Node(2);
//        System.out.println(calcLargestAvg(root));
//        System.out.println(largestAverage(root));
        Nnodes<Integer> root = new Nnodes<>(12);
        root.children.add(new Nnodes<>(1002));
        root.children.add(new Nnodes<>(1));
        root.children.get(0).children.add(new Nnodes<>(1000));
        System.out.println(largestAverageN(root));

    }

    public static double largestAverageN(Nnodes<Integer> root) {
        //check for null root here.
        Tracker t = helperN(root);
        return t.largestAvg;
    }

    public static Tracker helperN(Nnodes<Integer> root) {
        Tracker t = new Tracker();
        //if it is empty, you've reached a leaf node!!!
        if(root.children.isEmpty()) {
            t.sumOfNodes = root.data;
            t.numberOfNodes++;
            t.largestAvg = (double)t.sumOfNodes/t.numberOfNodes;
        }
        //IDEA TO MAKE THIS O(N) LINKED LIST WHILE ITERATING THROUGH ALL THE CHILDREN CURRENTLY!!!!!!
        Tracker temp;
        LinkedList<Double> childsAverages = new LinkedList<>();
        for(Nnodes<Integer> child : root.children) {
            temp = helperN(child);
            t.sumOfNodes += temp.sumOfNodes;
            t.numberOfNodes += temp.numberOfNodes;
            childsAverages.add(temp.largestAvg);
            //potentially add the avg to a linked list!!!!!!!!
        }
        //calculate the sum of this node, based on all the other nodes + current node and sum
        t.largestAvg = (double) (t.sumOfNodes + root.data) / (t.numberOfNodes + 1);
        for(double cAvg : childsAverages) {
            if (cAvg > t.largestAvg) {
                t.largestAvg = cAvg;
            }
        }
        //if the child ever has a larger sum than current largest sum, make childs sum change!
//        for(Nnodes<Integer> child : root.children) {
//            temp = helperN(child);
//            if(temp.largestAvg > t.largestAvg) {
//                t.largestAvg = temp.largestAvg;
//            }
//        }
        return t;
    }

    /**
     ******************************************************************************************
     * -------------------- O(n) YES --------------------------------------------------
     ******************************************************************************************
     */

    public static double largestAverage(Node root) {
        Tracker t = helper(root);
        return t.largestAvg;
    }

    public static Tracker helper(Node root) {
        Tracker t = new Tracker();
        if(root == null) { //if null, return the "default" tracker with all 0's
            return t;
        }
        Tracker left = helper(root.left);
        Tracker right = helper(root.right);
        if(root.left != null) { //increment num of nodes and sum of nodes
            t.numberOfNodes += left.numberOfNodes; //TODO: ADD 1 FOR CURRENT NODE COUNT
            t.sumOfNodes += left.sumOfNodes;  //TODO: ADD CURRENT SUM OF THIS NODE
            //If calc avg here in comparison to current avg, then assign?
        }
        if(root.right != null) {
            t.numberOfNodes += right.numberOfNodes;
            t.sumOfNodes += right.sumOfNodes;
        }
        //by now we should have accounted for all the left, all the right, but not current avg.
        //now we need the current nodes avg
        t.numberOfNodes++; //account for the current node
        t.sumOfNodes += root.data; //account for current node
        t.largestAvg = (double)t.sumOfNodes / t.numberOfNodes;
        //compare with left and right avgs
        if(left.largestAvg > t.largestAvg) {
            t.largestAvg = left.largestAvg;
        }
        if(right.largestAvg > t.largestAvg) {
            t.largestAvg = right.largestAvg;
        }
        return t;
    }

    /**
     ******************************************************************************************
     * -------------------- O(n^3) LOL YIKES --------------------------------------------------
     ******************************************************************************************
     */


    public static double calcLargestAvg(Node root) {
        if(root == null) {
            return 0;
        }
        double thisAvg = calcAvg(root);
        double leftAvg = calcAvg(root.left);
        double rightAvg = calcAvg(root.right);
        if(leftAvg > thisAvg) {
            thisAvg = leftAvg;
        }
        if(rightAvg > thisAvg) {
            thisAvg = rightAvg;
        }
        return thisAvg;

    }

    public static double calcAvg(Node root) {
        if(root == null) {
            return 0;
        }
        int sum = sumNodes(root);
        int count = countNodes(root);
        return (double)sum/count;
    }


    public static int sumNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int sum = root.data;
        return sumNodes(root.left) + sumNodes(root.right) + sum; //the + sum at the end is counting yourself!!!
    }

    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1; //the + 1 at the end is counting yourself!!!
    }
}
