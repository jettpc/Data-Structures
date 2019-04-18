package CCI;

/*
    Random Node: You are implementing a binary search tree class from scratch, which, in addition to insert,
    find, and delete has a method getRandomNode() which returns a random node from the tree. All nodes should
    be equally likely to be chosen. Design and implement an algorithm for getRandomNode, and explain how you
     would implement the rest of the methods
 */

import java.util.Random;

public class ch4_11_RandomNode {
//    static class Tree {
//        Node root = null;
//
//        public int size() {
//            return root == null ? 0 : root.size();
//        }
//
//        public Node getRandomNode() {
//            if(root == null)
//                return null;
//
//            Random r = new Random();
//            int i = r.nextInt(size());
//            return root.getIthNode(i);
//        }
//
//        public void insertInOrder(int v) {
//            if(root == null) {
//                root = new Node(v);
//            } else {
//                root.insertInOrder(v);
//            }
//        }
//    }


    // A Binary Tree node
    static class Node {
        int data;
        Node left, right;
        int size = 0;

        Node(int value) {
            data = value;
            left = right = null;
            size = 1;
        }

        public Node getRandomNode() {
            int leftSize = left == null ? 0 : left.size();
            Random random = new Random();
            int index = random.nextInt(size);
            if(index < leftSize) {
                return left.getRandomNode();
            } else if (index == leftSize) {
                return this;
            } else {
                return right.getRandomNode();
            }

        }



//        public Node getIthNode(int i) {
//            int leftSize = left == null ? 0 : left.size();
//            if( i < leftSize) {
//                return left.getIthNode(i);
//            } else if ( i == leftSize) {
//                return this;
//            } else {
//                return right.getIthNode(i - (leftSize + 1));
//            }
//        }

        public void insertInOrder(int d) {
            if(d <= data) {
                if(left == null) {
                    left = new Node(d);
                } else {
                    left.insertInOrder(d);
                }
            } else {
                if(right == null) {
                    right = new Node(d);
                } else {
                    right.insertInOrder(d);
                }
            }
            size++;
        }

        public int size() {
            return size;
        }

        public int data() {
            return data;
        }

        public Node find(int d) {
            if(d == data) {
                return this;
            } else if (d <= data) {
                return left != null ? left.find(d) : null;
            } else if (d > data) {
                return right != null ? right.find(d) : null;
            }
            return null;
        }
    }

    public static void main(String args[]) {
        Node n = new Node(5);

        n.insertInOrder(1);
        n.insertInOrder(2);
        n.insertInOrder(3);

        for(int i = 0; i < 10; i++) {
            System.out.println(n.getRandomNode().data);
        }

    }



}
