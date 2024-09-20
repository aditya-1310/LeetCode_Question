class Solution {
    public String shortestPalindrome(String s) {
      char[] reversed = new char[s.length()];
        int i = 0, j = s.length() - 1;
        while (j >= 0) {
            reversed[i++] = s.charAt(j--);
        }

        String combined = s + "#" + new String(reversed);
        int n = combined.length();
        int[] lps = new int[n];

        // Construct the failure function
        for (int k = 1; k < n; k++) {
            int prevJ = lps[k - 1]; // Rename the variable to avoid conflict
            while (prevJ > 0 && combined.charAt(k) != combined.charAt(prevJ)) {
                prevJ = lps[prevJ - 1];
            }
            if (combined.charAt(k) == combined.charAt(prevJ)) {
                prevJ++;
            }
            lps[k] = prevJ;
        }

        // Find the longest palindromic prefix
        int longestPrefix = lps[n - 1];

        // Prepend the reverse
        return new String(reversed).substring(0, s.length() - longestPrefix) + s;
    }
}