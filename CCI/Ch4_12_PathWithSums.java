package CCI;

/*
    Paths with Sum: You are given a binary tree in which each node contains an integer value
    (which might be positive or negative). Design an algorithm to count the number of paths that sum to a given value.
     The path does not need to start or end at the root or a leaf, but if must go downwards
     (traveling only from parent nodes to child nodes).
 */

public class Ch4_12_PathWithSums {

    // A Binary Tree node
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    public static void main(String args[]) {
        Node n = new Node(1);
        n.right = new Node(3);

        Node l = new Node(2);
        l.left = new Node(4);
        l.right = new Node(5);

        n.left = l;

        System.out.println(countPathsWithSum(n, 3));

    }

    public static int countPathsWithSum(Node root, int targetSum) {
        if(root == null) {
            return 0;
        }

        /* Count paths with sum starting from the root. */
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

        /* Try the nodes on the left and right. */
        int pathsOnLeft = countPathsWithSum(root.left, targetSum);
        int pathsOnRight = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    /* Returns the number of paths with this sum starting from this node. */
    public static int countPathsWithSumFromNode(Node n, int targetSum, int currentSum) {
        if(n == null) {
            return 0;
        }
        currentSum += n.data;

        int totalPaths = 0;
        if(currentSum == targetSum) {
            totalPaths++;
        }

        totalPaths += countPathsWithSumFromNode(n.left, targetSum, currentSum);
        totalPaths += countPathsWithSumFromNode(n.right, targetSum, currentSum);
        return totalPaths;
    }
}
