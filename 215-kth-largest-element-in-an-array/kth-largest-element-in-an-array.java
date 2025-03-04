class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int c=0;
        int val =0;
        while(c !=k){
         val =   pq.remove();
        c++;
        }

        return val;
    }
}