package graphs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Kedar Erande
 * <p>
 * https://leetcode.com/problems/network-delay-time/submissions/
 * TC: O(N+ELOGN)
 * Approach : Use either BFS - weigthed or Dijkstra using Weighted where arrival time is sorted in ascending. In short find the shortest pah
 */
class NetworkPair implements Comparator<NetworkPair> {

    int travelTime;
    int destination;


    public NetworkPair(int travelTime, int destination) {
        this.travelTime = travelTime;
        this.destination = destination;
    }

    @Override
    public int compare(NetworkPair o1, NetworkPair o2) {
        return o1.travelTime - o2.travelTime;
    }
}


public class NetworkDelay {


    private static void dijkstra(int[] signalReceivedAt, int source, int n, Map<Integer, List<NetworkPair>> adj) {
        Queue<NetworkPair> pq = new PriorityQueue<NetworkPair>
                (Comparator.comparing(o1 -> o1.travelTime));
        pq.add(new NetworkPair(0, source));

        // Time for starting node is 0
        signalReceivedAt[source] = 0;

        while (!pq.isEmpty()) {
            NetworkPair topPair = pq.poll();

            int srcTravelTime = topPair.travelTime;
            int destination = topPair.destination;

            if (srcTravelTime > signalReceivedAt[destination]) {
                continue;
            }


            // Broadcast the signal to adjacent nodes
            for (NetworkPair networkPair : adj.get(destination)) {
                int time = networkPair.travelTime;
                int neighborNode = networkPair.destination;

                // Fastest signal time for neighborNode so far
                // signalReceivedAt[currNode] + time :
                // time when signal reaches neighborNode
                if (signalReceivedAt[neighborNode] > srcTravelTime + time) {
                    signalReceivedAt[neighborNode] = srcTravelTime + time;
                    pq.add(new NetworkPair(signalReceivedAt[neighborNode], neighborNode));
                }
            }
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<NetworkPair>> adj = new HashMap<>();
        // Build the adjacency list
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new NetworkPair(travelTime, dest));
        }

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        dijkstra(signalReceivedAt, k, n, adj);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalReceivedAt[i]);
        }

        // INT_MAX signifies atleat one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        int times[][] =
                {
                        {2, 1, 1},
                        {2, 3, 1},
                        {3, 4, 1}
                };
        networkDelayTime(times, n, k);
    }

}
