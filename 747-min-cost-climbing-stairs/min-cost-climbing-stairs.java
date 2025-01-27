class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(n-1,dp,cost),solve(n-2,dp,cost));
    }

    public int solve(int n , int []dp , int [] cost){
        if(n<0) return 0;

        if(dp[n] !=-1) return dp[n];

        return dp[n] = Math.min(solve(n-1,dp,cost) , solve(n-2,dp,cost))+cost[n];
    }
    
}