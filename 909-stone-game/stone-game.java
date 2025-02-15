class Solution {
    int dp[][] ;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
         dp = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return rec(dp,piles,0,n-1) > 0;
    }
    public int rec(int dp[][] , int [] piles ,int i , int j){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int takeleft = piles[i] -  rec(dp,piles,i+1,j);
        int takeright = piles[j] - rec(dp,piles,i,j-1);

        return dp[i][j] = Math.max(takeleft, takeright);
    }
}