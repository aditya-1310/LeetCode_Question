class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long max  = 0;
       for(int k =2;k<n;k++){
            int mp = nums[0];
            for(int j =1;j<k;j++){
                max = Math.max(max,(long) (mp-nums[j])*nums[k]);
                mp = Math.max(mp , nums[j]);
            }
       }
        return max ;
    }
}