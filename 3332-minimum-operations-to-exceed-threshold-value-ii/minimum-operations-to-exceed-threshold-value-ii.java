class Solution {
    public int minOperations(int[] nums, int k) {
         PriorityQueue<Long> maxHeap = new PriorityQueue<>();
        
        
        int sum = 0;
        // Calculate the total sum of the array and add elements to the heap.
        for (int num : nums) {
            
            maxHeap.offer((long) num);
        }
        
       
        
        // Continue reducing until we achieve at least half the reduction.
        while (maxHeap.peek() < k) {
            // Extract the largest element from the heap.
            long largest = maxHeap.poll();
            long val = largest*2 + maxHeap.poll();
            maxHeap.offer(val);
            sum++; 
        }
        
        return sum;
    }
}