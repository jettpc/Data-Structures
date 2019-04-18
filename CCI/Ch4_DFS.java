package CCI;
import java.io.*;
import java.util.*;
public class Ch4_DFS {

    // This class represents a directed graph using adjacency list
    static class Graph
    {
        private int V; // No. of vertices
        private LinkedList<Integer>[] adj; // Array of lists for Adjacency List Representation

        Graph(int v) // Constructor
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        //Function to add an edge into the graph
        void addEdge(int v, int w)
        {
            adj[v].add(w); // Add w to v's list.
        }

        // A function used by DFS
        void DFSUtil(int v,boolean visited[])
        {
            visited[v] = true; // Mark the current node as visited and print it
            System.out.print(v+" ");
            System.out.println(visited);

            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) // Recur for all the vertices adjacent to this vertex
            {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        // The function to do DFS traversal. It uses recursive DFSUtil()
        void DFS(int v)
        {
            boolean visited[] = new boolean[V]; // Mark all the vertices as not visited(set false by default in java)
            DFSUtil(v, visited); // Call the recursive helper function to print DFS traversal
        }

        public static void main(String args[])
        {
            Graph g = new Graph(5);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 0);
            g.addEdge(1, 2);
            g.addEdge(1, 3);
            g.addEdge(2, 0);
            g.addEdge(2, 1);
            g.addEdge(2, 4);
            g.addEdge(3, 1);
            g.addEdge(4, 2);

            System.out.println("Following is Depth First Traversal (starting from vertex 2)");
            g.DFS(0);
        }
    }


}
