class Solution {
    public long mostPoints(int[][] questions) {
        long dp [] = new long[questions.length];
        Arrays.fill(dp,-1);
        return solve(questions,dp,0);
    }
    public long solve(int [][]questions,long []dp,int start){
        if(start >= questions.length){
            return 0;
        }
       
        if(dp[start]!=-1){
            return dp[start];
        }

        long t = questions[start][0] + (start + questions[start][1] + 1 < questions.length ? solve(questions, dp, start + questions[start][1] + 1) : 0);
        
        long nt = solve(questions,dp,start+1);
        dp[start] = Math.max(t,nt);
        return dp[start];
    }
}