class Solution {
    public int longestSubarray(int[] nums) {
        int maxe = Integer.MIN_VALUE;
        for(int i:nums){
            maxe = Math.max(maxe,i);
        }
        int ctn =1;
        int val =Integer.MIN_VALUE;
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==maxe){

            if(temp == nums[i]){
            ctn++;
            } 
            }
            else{
                temp=0;
                ctn=1;
            }
            temp = nums[i];
            val = Math.max(val,ctn);

        }

        return val;

    }
}