class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int diff =0;
        for(int i=0;i<nums.length-1;i++){
            diff = Math.max(diff,(nums[i+1]-nums[i]));
        }

        return diff;
    }
}