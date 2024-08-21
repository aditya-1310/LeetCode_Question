import java.util.HashMap;
import java.util.Map;

class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Initialize DP table
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1; // Single character needs 1 turn
        }

        // Fill DP table for substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = dp[i][j - 1] + 1; // Initial assumption: print s[i:j-1] and then s[j]
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j - 1]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
