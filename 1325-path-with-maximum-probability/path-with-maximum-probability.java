import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Initialize graph representation using an adjacency list
        Map<Integer, List<Pair<Integer, Double>>> adjacencyList = new HashMap<>();
        int edgeCount = edges.length;

        // Create a priority queue to track nodes with the highest probability first
        PriorityQueue<Pair<Integer, Double>> priorityQueue = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));

        // Build the graph from the edges and probabilities
        for (int i = 0; i < edgeCount; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            double probability = succProb[i];
            adjacencyList.computeIfAbsent(node1, k -> new ArrayList<>()).add(new Pair<>(node2, probability));
            adjacencyList.computeIfAbsent(node2, k -> new ArrayList<>()).add(new Pair<>(node1, probability));
        }

        // Array to store the maximum probability to reach each node
        double[] maxProbabilities = new double[n];
        maxProbabilities[start] = 1.0;

        // Start processing from the start node
        priorityQueue.add(new Pair<>(start, 1.0));

        while (!priorityQueue.isEmpty()) {
            Pair<Integer, Double> current = priorityQueue.poll();
            int currentNode = current.getKey();
            double currentProbability = current.getValue();

            // If we reach the end node, return the maximum probability found
            if (currentNode == end) {
                return currentProbability;
            }

            // Skip if the node has no neighbors (which shouldn't happen due to the graph setup)
            if (!adjacencyList.containsKey(currentNode)) continue;

            // Process all neighbors of the current node
            for (Pair<Integer, Double> neighbor : adjacencyList.get(currentNode)) {
                int nextNode = neighbor.getKey();
                double edgeProbability = neighbor.getValue();
                double newProbability = currentProbability * edgeProbability;

                // If this path offers a higher probability to reach the next node, update and enqueue
                if (newProbability > maxProbabilities[nextNode]) {
                    maxProbabilities[nextNode] = newProbability;
                    priorityQueue.add(new Pair<>(nextNode, newProbability));
                }
            }
        }

        // If the end node is unreachable, return 0
        return 0.0;
    }
}
