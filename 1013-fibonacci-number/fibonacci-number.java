class Solution {
    public int fib(int n) {
    //      int dp[] = new int[n+1];
    if(n<=1) return n;
    // dp[0] =0;
    // dp[1]=1;
    // for(int i=2;i<=n;i++) {
    //     dp[i] = dp[i-1]+dp[i-2];
    // }
    // return dp[n];
    int a=0;
    int b =1;
    int c =0;
    for(int i=1;i<n;i++){
        c = a+b;
        a=b;
        b=c;
    }
    return c;
    }
}