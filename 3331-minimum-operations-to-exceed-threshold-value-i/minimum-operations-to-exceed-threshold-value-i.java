class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
      
        for(int i:nums){
         
            pq.add(i);
        }
        
        int redu =0;
        
            while(pq.peek()<k && !pq.isEmpty()){
                pq.poll();
                redu++;
            }
            

    
        return redu;
    }
}