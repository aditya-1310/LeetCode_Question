class Solution {
    public boolean canSortArray(int[] nums) {
        int curr_min = nums[0], curr_max = nums[0];
        int prev_max = -1;
        for(int ele : nums) {
            if(Integer.bitCount(ele) == Integer.bitCount(curr_min)) {
                curr_min = Math.min(curr_min, ele);
                curr_max = Math.max(curr_max, ele);
            }
            else {
                if(curr_min < prev_max) return false;
                prev_max = curr_max;
                curr_min = ele;
                curr_max = ele;
            }
        }
        if(curr_min < prev_max) return false;
        return true;
    }
}