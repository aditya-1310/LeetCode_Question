class Solution {
    public String longestPalindrome(String s) {
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (isPalindrome(j, j + i - 1, s)) {
                    return s.substring(j, j + i);
                }
            }
        }
        return "";
    }

    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
