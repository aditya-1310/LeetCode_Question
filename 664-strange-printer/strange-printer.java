import java.util.HashMap;
import java.util.Map;

class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] cp = new int[n][n];

        // Initialize DP table
        for (int i = 0; i < n; i++) {
            cp[i][i] = 1; // Single character needs 1 turn
        }

        // Fill DP table for substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                cp[i][j] = cp[i][j - 1] + 1; // Initial assumption: print s[i:j-1] and then s[j]
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        cp[i][j] = Math.min(cp[i][j], cp[i][k] + cp[k + 1][j - 1]);
                    }
                }
            }
        }

        return cp[0][n - 1];
    }
}
