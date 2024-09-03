class Solution {
    public int removeDuplicates(int[] nums) {
       int uni = 1;
       for(int i=1;i<nums.length;i++){
        if(nums[i]!=nums[i-1]){
             nums[uni] = nums[i];
            uni++;
        }
       }
       return uni;
    }
}
