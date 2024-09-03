class Solution {
    public boolean check(int[] nums) {
        int ctn =0;
        if(nums[0]<nums[nums.length-1]){
            ctn++;
        }
     for(int i=0;i<nums.length-1;i++){
        if(nums[i]>nums[i+1]) {
            ctn ++;
        }
        }
        if(ctn >1) return false;

        return true;

     
    }
}