class Solution {
    public boolean canJump(int[] nums) {
       int n = nums.length;
       boolean dp[] = new boolean[n];
       if(n==1) return true;
       dp[0] = true;
       for(int i=0;i<n-1;i++){
        if(dp[i]){
            for(int j=1;j<=nums[i];j++){
                if(i+j == n-1){
                    return true;
                }
                dp[i+j] = true;
            }
        }
       }
        return false ;
    }

}