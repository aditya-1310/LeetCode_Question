class Solution {
 
    public int rob(int[] nums) {
        
        int n = nums.length;
         if (n == 1) return nums[0];
         int dp[] = new int[n+1];
         Arrays.fill(dp,-1);
        int n1 = solve(nums,0,n-2,dp);
        int dp1[] = new int[n+1];
         Arrays.fill(dp1,-1);
        int n2 = solve(nums,1,n-1,dp1);

        return Math.max(n1,n2);
            
    }
    public int solve(int nums[],int i,int e,int dp[]){
        if(i > e) return 0;
        if(dp[i]!=-1) return dp[i];
        int t = nums[i] + solve(nums,i+2 ,e,dp);
        int nt =  solve(nums,i+1,e,dp);

            return dp[i] = Math.max(t,nt);
    }
}