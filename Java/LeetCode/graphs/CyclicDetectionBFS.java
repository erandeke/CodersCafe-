package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * //Unidirected Graph
 * @author Kedar Erande
 */

class Node {
    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class CyclicDetectionBFS {

    private static boolean checkIfCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean visited[], Queue<Node> queue) {
        queue.add(new Node(node, -1));
        visited[node] = true;

        while (!queue.isEmpty()) {
            int first = queue.peek().first;
            int parent = queue.peek().second;
            queue.poll();

            for (Integer val : adj.get(first)) {
                if (!visited[val]) {
                    queue.add(new Node(val, first));
                    visited[val] = true;

                } else if (val != parent) {
                    return true;
                }
            }


        }

        return false;
    }

    private static void add(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 5;
        for (int i = 1; i <= v+1; i++) {
            adj.add(new ArrayList<>());
        }
        boolean visited[] = new boolean[adj.size()];
        Queue<Node> queue = new LinkedList<>();

        add(adj, 1, 2);
        add(adj, 2, 3);
        add(adj, 2, 4);
        add(adj, 4, 5);
        add(adj, 3, 5);
        for (int i = 1; i < adj.size(); i++) {
            if (!visited[i]) {
                checkIfCycle(i, adj, visited, queue);
            }
        }


    }
}
