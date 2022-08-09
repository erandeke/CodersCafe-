package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Kedar Erande
 */
public class TopoBFS {

    int V;

    public void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adj) {
        adj.get(u).add(v);
    }


    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int topo[] = new int[N];
        int indegree[] = new int[N];

        //finding indegree
        for (int i = 0; i < N; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }


        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            //adding nodes to queue with indegree = 0
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;
        int ind = 0;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            topo[ind++] = node;
            cnt++;
            //getting neighbour nodes of popped node and decreasing  their
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        //printing topological ordering of nodes
        for (int i = 0; i < topo.length; i++) {
            System.out.print(topo[i] + " ");
        }
        if (cnt == N) return false;
        return true;
    }
}


// Driver program to test above functions
class Main {
    public static void main(String args[]) {
        // Create a graph given in the above diagram
        TopoBFS g = new TopoBFS();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }

        g.addEdge(5, 2, adj);
        g.addEdge(5, 0, adj);
        g.addEdge(4, 0, adj);
        g.addEdge(4, 1, adj);
        g.addEdge(2, 3, adj);
        g.addEdge(3, 1, adj);

        g.isCyclic(6, adj);
    }
}
