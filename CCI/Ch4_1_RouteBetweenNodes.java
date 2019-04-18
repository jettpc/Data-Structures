package CCI;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 */

// Java program to check if there is exist a path between two vertices
// of a graph.
import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Ch4_1_RouteBetweenNodes {

    public static void main(String[] args)
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(0, 5);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 1);
        g.addEdge(3, 2);
        g.addEdge(3, 4);

//        HashMap<Integer, HashSet<Integer>> test = new HashMap<Integer, HashSet<Integer>>();
//        HashSet<Integer> in = new HashSet<Integer>();
//        in.add(1);
//        in.add(2);
//        in.add(1);
//        test.put(0,in);
//        test.put(2,in);
//        test.get(0).add(3);
//        System.out.println(test.containsKey(0));
//        System.out.println(test.containsValue(1));
//        System.out.println(test.get(0).contains(2));
//        System.out.println(test.toString());

       // System.out.println(isPathViaBFS(g, 0, 2));



        MyNode<Integer> root = new MyNode<Integer>(1);
        root.children = new LinkedList<MyNode<Integer>>();
        root.children.add(new MyNode<Integer>(2));
        root.children.add(new MyNode<Integer>(3));
        root.children.get(1).children.add(new MyNode<Integer>(4));

        MyNode<Integer> root1 = new MyNode<Integer>(1);
        root1.children = new LinkedList<MyNode<Integer>>();
        root1.children.add(new MyNode<Integer>(2));
       System.out.println("test: " + (root1.children.get(0).children.isEmpty()));

        System.out.println(root.data);
        for(MyNode adsf : root.children) {
            System.out.println(adsf.data);
        }

    }


//    // -------- Technique One!!! --------
//    static class Graph2 {
//        private LinkedList<LinkedList<Integer>> asdf;
//
//        public Graph2() {
//            asdf = new LinkedList<LinkedList<Integer>>();
//        }
//
//        public void addEdge(int from, int to) {
//            for(LinkedList<Integer> list : asdf) {
//                if()
//            }
//        }
//
//    }

    public static class MyNode<T> {
        private T data;
        private LinkedList<MyNode<T>> children;

        public MyNode(T data) {
            this.data = data;
            this.children = new LinkedList<MyNode<T>>();
        }
    }


























     //create an adjacency list to represent the graph
     static class Graph {
            private int numOfNodes; //fixed number of Nodes once graph is created
            private LinkedList<Integer>[] adjList; //need numOfNodes before this can be instantiated

            public Graph(int num) { //constructor
                numOfNodes = num;
                adjList = new LinkedList[numOfNodes]; //this is the weird way of allocating memory for an array of objects

                for(int i = 0; i < numOfNodes; i++) {
                    adjList[i] = new LinkedList<Integer>();
                }
            }

            public void addEdge(int from, int to) {
                adjList[from].add(to);
            }
        }


        //BFS that returns true if a path from start to end exists
        public static boolean isPathViaBFS(Graph g, int start, int end) {
            boolean[] visited = new boolean[g.numOfNodes];
            LinkedList<Integer> queue = new LinkedList<Integer>();
            int adjNode;

            queue.add(start);
            visited[start] = true;

            Iterator<Integer> i; //iterator for adj list of nodes connected to current node (called "start")

            while(!queue.isEmpty()) { //while the Q is not empty, keep checking nodes

                start = queue.poll(); //remove head from list and check its neighbors!!!
                i = g.adjList[start].iterator(); //iterator for current node (called "start")
                System.out.println("Iterating over adjNodes to: " + start);
                while(i.hasNext()) { //while the current node has adj nodes
                    adjNode = i.next();
                    System.out.println("Checking node: " + adjNode);

                    if(adjNode == end) {
                        System.out.println("Found ya boi!!!" + adjNode + "  " + end);
                        return true;
                    }
                    if(!visited[adjNode]) { //if this node has not been visited, add it to the q and mark as visisted
                        visited[adjNode] = true;
                        queue.add(adjNode);
                        System.out.println("Currently adding adjNode: " + adjNode + " to the Q");
                    }
                }
            }

            return false;
        }





}
