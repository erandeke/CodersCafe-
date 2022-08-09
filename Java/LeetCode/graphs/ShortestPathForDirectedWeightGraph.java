package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Kedar Erande
 * //this is alogorithm is done via using Top sort
 * //Can we do it using just DFS or BFS ? Yes  possible but see ans below
 * <p>
 * lets say you want to do it using DFS
 * yes you can do it using DFS , but consider the case when you already updated a node's distance by a dfs() call and
 * lets say its 7 and as it is DFS then its obvious that you also have updated all the nodes in its segment of DFS call .
 * now you have reached to the same node from different dfs() call and now the distance is 4 ,
 * so in order to update all the nodes which were affected by the DFS call previously on the node considering distance as 7 ,
 * you now again have to do the same so that its updated with new min distance.
 * Same is the scenario for the simple BFS approach.
 * This multiple time calling DFS/BFS degrades the Time Complexity,
 * hence Topological Ordering save you from that overhead as you already know which nodes will come after the current node , so you keep on updating it .
 */

class Pair {
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

public class ShortestPathForDirectedWeightGraph {


    public static void addEdge(int u, Pair pair, ArrayList<ArrayList<Pair>> adj) {
        adj.get(u).add(pair);
    }

    public static void dfsTopoLogicalSort(int node, int visited[], ArrayList<ArrayList<Pair>> adj, Stack<Integer> stack) {
        visited[node] = 1;
        for (Pair subNode : adj.get(node)) {
            if (visited[subNode.getNode()] == 0) {
                dfsTopoLogicalSort(subNode.getNode(), visited, adj, stack);
            }
        }
        stack.push(node);
    }

    public static void generateShortestPath(Stack<Integer> stack, ArrayList<ArrayList<Pair>> adj) {
        int distance[] = new int[6];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            for (Pair pair : adj.get(node)) {
                if (distance[node] + pair.getWeight() < distance[pair.getNode()]) {
                    distance[pair.getNode()] = distance[node] + pair.getWeight();
                }
            }

        }
        printArray(distance);

    }

    public static void printArray(int distance[]) {
        for (Integer i : distance) {
            System.out.println("Distance array" + i);
        }
        //final array will be  0,2,5,3,1,2
        //that denotes  from source 0 to destination index 3  (1,1,1) hence at index 3  path is 0 ->4 -> 5
        // lets travel from source 0 to destination 5 (index 5)  is 2  from: 0 0-> 4 (1)-> 5 (1)
    }


    public static void main(String[] args) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(0, new Pair(1, 2), adj);
        addEdge(1, new Pair(2, 3), adj);
        addEdge(2, new Pair(3, 6), adj);
        addEdge(0, new Pair(4, 1), adj);
        addEdge(4, new Pair(5, 1), adj);
        addEdge(5, new Pair(3, 1), adj);
        Stack<Integer> stack = new Stack<Integer>();

        int visited[] = new int[6];

        for (int i = 0; i < 6; i++) {
            if (visited[i] != 1) { //this condition is always use to handle #different components of graphs c1 , c2 etc
                dfsTopoLogicalSort(i, visited, adj, stack);
            }
        }

        generateShortestPath(stack, adj);

    }
}
