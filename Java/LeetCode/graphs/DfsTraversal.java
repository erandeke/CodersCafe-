package graphs;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 */
public class DfsTraversal {

    private static void add(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private static ArrayList<Integer> traverseDFS(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result, boolean visited[]) {
        result.add(node);
        visited[node] = true;
        for (Integer val : adj.get(node)) {
            if (!visited[val]) {
                visited[val] = true;
                traverseDFS(val, adj, result, visited);
            }
        }
        return result;

    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int noOfVertices = 7;
        for (int i = 0; i <= noOfVertices; i++) {
            arr.add(new ArrayList<>());
        }

        add(arr, 1, 2);
        add(arr, 2, 3);
        add(arr, 2, 7);
        add(arr, 7, 5);
        add(arr, 3, 5);
        add(arr, 4, 6);

        System.out.println(arr.size());
        boolean visited[] = new boolean[arr.size()];
        for (int i = 1; i < arr.size(); i++) {
            if (!visited[i]) {
                traverseDFS(i, arr, new ArrayList<>(), visited);
            }
        }


    }
}
