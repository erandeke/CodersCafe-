package graphs;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 * //Created adjacent matrix for unidirect graph
 */
public class AdjacentMatrix {

    private static void add(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    private static void print(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 1; i < adj.size(); i++) {
            System.out.println("From vertex" + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.println("Edges are " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int noOfVertices = 7;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(noOfVertices);

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


    }
}
