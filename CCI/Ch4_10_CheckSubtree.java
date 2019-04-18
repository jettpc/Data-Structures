package CCI;

/*
    Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an algorithm
    to determine if T2 is a subtree of T1.

    A tree T2 is a subtree of T2 if there exists a node n in T1 such that the subtree of n is identical to T2.
    That is, if you cut off the tree at node n, the two trees would be identical.
 */


public class Ch4_10_CheckSubtree {

    // A Binary Tree node
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    public static void main(String[] s) {
        Node n = new Node(1);
        n.right = new Node(3);

        Node l = new Node(2);
        l.left = new Node(4);
        l.right = new Node(5);

        n.left = l;

        System.out.println(containsTree(n,l));
    }

    public static boolean containsTree(Node t1, Node t2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        preOrderTraversal(t1, s1);
        preOrderTraversal(t2, s2);

        //check if there exists a substring s2 in s1;
        return s1.indexOf(s2.toString()) != -1;
    }

    public static void preOrderTraversal(Node n, StringBuilder sb) {
        if(n == null) {
            sb.append("x");
            return;
        }

        sb.append(n.data);
        preOrderTraversal(n.left, sb);
        preOrderTraversal(n.right, sb);
    }
}
