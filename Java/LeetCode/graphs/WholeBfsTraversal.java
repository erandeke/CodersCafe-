package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kedar Erande
 */
public class WholeBfsTraversal {

    private static void add(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private static ArrayList<Integer> bfsTraversal(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result, int source) {
        boolean visited[] = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < adj.size(); i++)
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    result.add(node);
                    for (Integer val : adj.get(node)) {
                        if (!visited[val]) {
                            visited[val] = true;
                            queue.add(val);
                        }
                    }

                }
            }
        return result;


    }


    private static void print(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 1; i < adj.size(); i++) {
            System.out.println("From vertex the edges are" + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.println("" + adj.get(i).get(j));
            }
            System.out.println();
        }
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

        print(arr);
        ArrayList<Integer> paths = bfsTraversal(arr, new ArrayList<>(), 2);
        System.out.println(paths);

    }
}