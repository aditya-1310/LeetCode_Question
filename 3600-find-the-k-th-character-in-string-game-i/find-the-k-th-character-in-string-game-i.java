class Solution {
    public char kthCharacter(int k) {
        StringBuilder str = new StringBuilder("a");
        return solve(k, str);
    }

    public String next(String input) {
        StringBuilder shiftedString = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                // Wrap around for lowercase letters
                shiftedString.append(ch == 'z' ? 'a' : (char) (ch + 1));
            } else {
                shiftedString.append(ch); // Non-alphabet characters (though there shouldn't be any)
            }
        }
        return shiftedString.toString();
    }

    public char solve(int k, StringBuilder ab) {
       
        while (ab.length() < k) {
            String newn = next(ab.toString());
            ab.append(newn);
        }
        // Return the k-th character (1-based index in the problem, 0-based in Java)
        return ab.charAt(k - 1);
    }
    
   
}
