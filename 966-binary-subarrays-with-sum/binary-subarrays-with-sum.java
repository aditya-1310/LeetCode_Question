class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       int sum =0;int totalcount=0;
       int prefixsum[] = new int[nums.length+1];
       prefixsum[0] =1;
        for(int num:nums){
            sum+= num;
            if(sum>=goal){
            totalcount += prefixsum[sum-goal];
            }
            prefixsum[sum]++;
        }

        return totalcount;
    }
}