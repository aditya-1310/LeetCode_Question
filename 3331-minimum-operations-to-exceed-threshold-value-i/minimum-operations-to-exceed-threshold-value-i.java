class Solution {
    public int minOperations(int[] nums, int k) {
        // Create a min-heap (PriorityQueue) to get the smallest elements easily
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Add all elements to the priority queue
        for (int num : nums) {
            pq.add(num);
        }

        int operations = 0;

        // Remove elements that are smaller than k
        while (!pq.isEmpty() && pq.peek() < k) {
            pq.poll(); // Remove the smallest element
            operations++; // Count this as an operation
        }

        return operations;
    }
}
