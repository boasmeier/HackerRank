/* Problem: https://www.hackerrank.com/challenges/favourite-sequence/problem
 * Language: Java 8
 */

import java.io.*;
import java.util.*;

public class Solution {

    // No. of vertices
    private final int V;

    // An Array of List which contains
    // references to the Adjacency List of
    // each vertex
    private final HashMap<Integer, ArrayList<Integer>> adj;

    // Constructor
    public Solution() {
        adj = new HashMap<>();

        this.V = readAndCreateAdj();
    }

    // Function to add an edge to graph
    public void addEdge(int src, int dest) {
        this.adj.get(src).add(dest);
    }

    // prints a Topological Sort of the
    // complete graph
    public void topologicalSort() {
        // Create a array to store indegrees of all
        // vertices. Initialize all indegrees as 0.
        HashMap<Integer, Integer> indegree = new HashMap<>();

        int i;
        int buff;

        for (Map.Entry<Integer, ArrayList<Integer>> entry : this.adj.entrySet()) {
            i = entry.getKey();
            indegree.put(i, 0);
        }
        // Traverse adjacency lists to fill indegrees of
        // vertices. This step takes O(V+E) time
        for (Map.Entry<Integer, ArrayList<Integer>> entry : this.adj.entrySet()) {
            i = entry.getKey();

            for (int var : this.adj.get(i)) {
                buff = indegree.get(var);
                buff++;
                indegree.put(var, buff);
            }
        }

        // Create a queue and enqueue
        // all vertices with indegree 0
        Queue<Integer> q = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            i = entry.getKey();
            if (indegree.get(i) == 0) {
                q.add(i);
            }
        }

        // Initialize count of visited vertices
        int cnt = 0;

        // Create a vector to store result
        // (A topological ordering of the vertices)
        List<Integer> topOrder = new LinkedList<>();
        while (!q.isEmpty()) {
            // Extract front of queue
            // (or perform dequeue)
            // and add it to topological order
            int u = q.poll();
            topOrder.add(u);

            // Iterate through all its
            // neighbouring nodes
            // of dequeued node u and
            // decrease their in-degree
            // by 1
            for (int node : adj.get(u)) {
                // If in-degree becomes zero,
                // add it to queue

                buff = indegree.get(node);
                buff--;
                indegree.put(node, buff);

                if (indegree.get(node) == 0) {
                    q.add(node);
                }
            }
            cnt++;
        }

        
        // Print topological order
        for (int j : topOrder) {
            System.out.print(j + " ");
        }
        
    }

    private int readAndCreateAdj() {
        // Read from stdin and store lines into an array
        Scanner sc = new Scanner(System.in);
        String[] input = new String[10000];
        int i = -1;
        while (sc.hasNextLine()) {
            i++;
            input[i] = sc.nextLine();
        } 
        sc.close();

        // Process Data and create the Graph by a adjacency list
        int nxt = 0;
        int prv;
        for (int j = 0; j <= i; j++) {
            prv = 0;
            sc = new Scanner(input[j]);
            while (sc.hasNextInt()) {
                nxt = sc.nextInt();
                
                if (prv > 0) {
                    if (!adj.containsKey(prv)) {
                        adj.put(prv, new ArrayList<>());
                    }
                    if (!adj.containsKey(nxt)) {
                        adj.put(nxt, new ArrayList<>());
                    }
                    addEdge(prv, nxt);
                }
                prv = nxt;
            }
        }
        return adj.size();
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Solution g = new Solution();

        //System.out.println("Following is a Topological Sort");
        g.topologicalSort();
    }
}