import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Construct the graph using an adjacency list representation
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            double probability = succProb[i];
            graph.computeIfAbsent(node1, k -> new ArrayList<>()).add(new Pair<>(node2, probability));
            graph.computeIfAbsent(node2, k -> new ArrayList<>()).add(new Pair<>(node1, probability));
        }

        // Array to store the maximum probability to reach each node
        double[] maxProbabilities = new double[n];
        maxProbabilities[start] = 1.0;

        // Priority queue to process nodes in descending order of probability
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
        pq.add(new Pair<>(1.0, start));

        // Dijkstra's-like approach to calculate the maximum probability path
        while (!pq.isEmpty()) {
            Pair<Double, Integer> current = pq.poll();
            double currentProb = current.getKey();
            int currentNode = current.getValue();

            // If the end node is reached, return the current probability
            if (currentNode == end) {
                return currentProb;
            }

            // Explore neighboring nodes
            for (Pair<Integer, Double> neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                int nextNode = neighbor.getKey();
                double edgeProb = neighbor.getValue();
                double newProb = currentProb * edgeProb;

                // If a higher probability path to nextNode is found, update and push to the queue
                if (newProb > maxProbabilities[nextNode]) {
                    maxProbabilities[nextNode] = newProb;
                    pq.add(new Pair<>(newProb, nextNode));
                }
            }
        }

        // Return 0 if there's no valid path to the end node
        return 0.0;
    }
}
