import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Adjacency list representation of the graph
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency list with flight data
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            adj.get(u).add(new int[]{v, price});
        }

        // PriorityQueue (min-heap) to store (cost, node, stops)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[]{0, src, 0}); // {current cost, current node, current stops}

        // Track the number of stops for each node
        int[][] stopsTracker = new int[n][k + 2];
        for (int[] arr : stopsTracker) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        stopsTracker[src][0] = 0;

        // Process the heap
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currCost = current[0];
            int node = current[1];
            int stops = current[2];

            // If we reached the destination within the allowed stops, return the cost
            if (node == dst) {
                return currCost;
            }

            // If stops exceed k, skip further processing
            if (stops > k) continue;

            // Traverse adjacent nodes
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int price = neighbor[1];
                int newCost = currCost + price;

                // Check if this path is better considering the number of stops
                if (newCost < stopsTracker[nextNode][stops + 1]) {
                    stopsTracker[nextNode][stops + 1] = newCost;
                    minHeap.add(new int[]{newCost, nextNode, stops + 1});
                }
            }
        }

        return -1; // If no path is found within k stops
    }
}
