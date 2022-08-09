package graphs;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 */
public class CyclicDetectionDirectGraph {


    public static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adj) {
        adj.get(u).add(v);
    }


    public void print(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 1; i < adj.size(); i++) {
            System.out.println("vertex ->" + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.println("Adj matrix " + adj.get(i).get(j));
            }
        }
    }

    public static boolean checkCycleInDirectedGraph(int node, int visited[], int dfsVisited[],
                                                    ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        dfsVisited[node] = 1;

        for (Integer it : adj.get(node)) {
            if (visited[it] == 0) {
                if (checkCycleInDirectedGraph(it, visited, dfsVisited, adj))
                    return true;
            } else if (dfsVisited[it] == 1) {
                return true;
            }
        }
        dfsVisited[node] = 0;
        return false;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int visted[] = new int[6];
        int dfsVisited[] = new int[6];


        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(0, 1, adj);
        addEdge(1, 2, adj);
        addEdge(2, 3, adj);
        addEdge(0, 4, adj);
        addEdge(4, 5, adj);
        addEdge(5, 3, adj);


        for (int i = 0; i < adj.size(); i++) {
            if (visted[i] != 1) {
                if (checkCycleInDirectedGraph(i, visted, dfsVisited, adj)) {
                    System.out.println("found cycle");
                }
            }
        }

    }
}
