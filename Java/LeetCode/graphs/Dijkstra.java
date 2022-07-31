package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Kedar Erande
 */

class PairNode implements Comparator<PairNode> {
    int node;
    int weight;

    public PairNode(int node, int weight) {
        this.weight = weight;
        this.node = node;
    }

    public PairNode() {

    }

    @Override
    public int compare(PairNode o1, PairNode o2) {
        return o1.weight - o2.weight;
    }
}

public class Dijkstra {

    private static void add(ArrayList<ArrayList<PairNode>> adj, int u, PairNode pair) {
        adj.get(u).add(pair);
    }

    public static void findDijkstraAlgoShortestPath(ArrayList<ArrayList<PairNode>> adj) {

        PriorityQueue<PairNode> pairNodesQueue = new PriorityQueue<PairNode>(new PairNode());
        pairNodesQueue.add(new PairNode(1, 0));
        int distance[] = new int[6];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        while (!pairNodesQueue.isEmpty()) {
            PairNode pairNode = pairNodesQueue.poll();

            for (PairNode p : adj.get(pairNode.node)) {
                int new_weight = p.weight;
                int source_weight = distance[pairNode.weight];
                if (source_weight + new_weight < distance[p.node]) {
                    distance[p.node] = source_weight + new_weight;
                    pairNodesQueue.add(new PairNode(p.node, distance[p.node]));
                }

            }
        }


    }


    public static void main(String[] args) {
        ArrayList<ArrayList<PairNode>> arr = new ArrayList<>();
        int noOfVertices = 6;
        for (int i = 0; i < noOfVertices; i++) {
            arr.add(new ArrayList<>());
        }

        add(arr, 1, new PairNode(2, 2));
        add(arr, 2, new PairNode(5, 5));
        add(arr, 1, new PairNode(4, 1));
        add(arr, 4, new PairNode(3, 3));
        add(arr, 3, new PairNode(2, 4));
        add(arr, 2, new PairNode(5, 1));

        findDijkstraAlgoShortestPath(arr);


    }
}
