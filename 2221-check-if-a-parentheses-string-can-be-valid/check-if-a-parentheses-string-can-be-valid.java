class Solution {
    public boolean canBeValid(String s, String locked) {
        // If the length of the string is odd, it's impossible to balance the parentheses
        if (s.length() % 2 != 0) return false;

        // First left-to-right pass to check for enough opening parentheses
        int open = 0;  // Tracks fixed '('
        int flexible = 0;  // Tracks positions that can be changed ('0' in locked)
        
        // Left to right: Ensure valid parentheses from the start
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    open++;  // Count fixed opening parentheses
                } else {
                    open--;  // We are encountering a fixed closing parenthesis
                }
            } else {
                flexible++;  // We can change it to either '(' or ')'
            }

            // At any point, if open < 0 and we can't recover using flexible, it's invalid
            if (open < -flexible) return false;
        }
        
        // Now, we check from the right to ensure valid closing parentheses
        open = 0;
        flexible = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') {
                    open++;  // Count fixed closing parentheses
                } else {
                    open--;  // We are encountering a fixed opening parenthesis
                }
            } else {
                flexible++;  // We can change it to either '(' or ')'
            }

            // At any point, if open < -flexible and we can't recover using flexible, it's invalid
            if (open < -flexible) return false;
        }

        return true;  // If we pass both checks, the string can be valid
    }
}
