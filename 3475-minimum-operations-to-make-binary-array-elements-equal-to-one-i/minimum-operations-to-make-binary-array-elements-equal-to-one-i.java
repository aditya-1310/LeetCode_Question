class Solution {
    public void flip(int[] nums, int i) {
        nums[i] = (nums[i] == 0) ? 1 : 0;
    }

    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                flip(nums, i);
                flip(nums, i + 1);
                flip(nums, i + 2);
                res++;
            }
        }
        
        // System.out.println(res)
        if(nums[nums.length - 2]==0  || nums[nums.length - 1]==0 ) {
            return -1;
        }
        return res;
    }
        
}
