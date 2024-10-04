class Solution {
    public int minMoves(int[] nums) {
        if(nums.length==1) return 0;
        Arrays.sort(nums);

        int val =0;
        int exp = nums[0];
        for(int i:nums){
        val+= i-exp;
        }
       
        
       return val; 
    }
}