class Solution {
    public int minInsertions(String s) {
        int ans = 0;  // To count the number of insertions
        int open = 0; // To track unmatched '('

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // We have encountered an open parenthesis
                open++;
            } else {
                // We have encountered a closing parenthesis
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // This is a pair of '))', consume one open if available
                    if (open > 0) {
                        open--;
                    } else {
                        // No matching open, so we need to add one '('
                        ans++;
                    }
                    // Move past the next ')'
                    i++;
                } else {
                    // This is a single ')', we need one more ')' to make it valid
                    if (open > 0) {
                        open--; // Use one open to match ')'
                        ans++;  // Add one more ')' to make it '))'
                    } else {
                        // No matching open, so we need to add one '(' and one ')'
                        ans += 2;
                    }
                }
            }
        }

        // If there are still unmatched open parentheses, we need to add two ')' for each
        ans += open * 2;

        return ans;
    }
}
