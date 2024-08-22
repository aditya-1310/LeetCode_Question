import java.util.HashMap;
import java.util.Map;

class Solution {
    public int strangePrinter(String s) {
    //     int n = s.length();
    //     int[][] cp = new int[n][n];

    //     // Initialize DP table
    //     for (int i = 0; i < n; i++) {
    //         cp[i][i] = 1; // Single character needs 1 turn
    //     }

    //     // Fill DP table for substrings of length 2 to n
    //     for (int len = 2; len <= n; len++) {
    //         for (int i = 0; i <= n - len; i++) {
    //             int j = i + len - 1;
    //             cp[i][j] = cp[i][j - 1] + 1; // Initial assumption: print s[i:j-1] and then s[j]
    //             for (int k = i; k < j; k++) {
    //                 if (s.charAt(k) == s.charAt(j)) {
    //                     cp[i][j] = Math.min(cp[i][j], cp[i][k] + cp[k + 1][j - 1]);
    //                 }
    //             }
    //         }
    //     }

    //     return cp[0][n - 1];
    int n =s.length();
    int t[][] = new int [n+1][n+1];
    for(int in[]:t){
        Arrays.fill(in,-1);
    }
    return solve(0,n-1,s,t);

    }
    public int solve(int l , int r,String s,int [][]t){
        if(l==r) return 1;
        if(l>r) return 0;
        if(t[l][r] != -1) return t[l][r];
        int i=l+1;
        while(i<=r && s.charAt(i)==s.charAt(l)){
            i++;
        }
        if(i==r+1) return 1;

        int ans = 1+solve(i,r,s,t);

        int res =Integer.MAX_VALUE;
        for(int j=i;j<=r;j++){
            if(s.charAt(j)==s.charAt(l)) {
            res = Math.min(res,(solve(i,j-1,s,t) + solve(j,r,s,t)));
            }
        }
                
        return t[l][r] = Math.min(ans,res);
    }
}
