package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kedar Erande
 */
public class DfsCycylic {
    private static void add(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private static boolean isCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
        visited[node] = true;
        for (Integer val : adj.get(node)) {
            if (!visited[val]) {
                visited[val] = true;
               return isCycle(val, node, adj, visited);
            } else if (val != parent)
                return true;
        }
        return false;

    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 5;
        for (int i = 1; i <= v + 1; i++) {
            adj.add(new ArrayList<>());
        }
        boolean visited[] = new boolean[adj.size()];
        add(adj, 1, 2);
        add(adj, 2, 3);
        add(adj, 3, 4);
        add(adj, 4, 5);
        add(adj, 5, 2);
        for (int i = 1; i < adj.size(); i++) {
            if (!visited[i]) {
                if (isCycle(i, -1, adj, visited))
                    System.out.println("yes cycle");
            }
        }

    }
}