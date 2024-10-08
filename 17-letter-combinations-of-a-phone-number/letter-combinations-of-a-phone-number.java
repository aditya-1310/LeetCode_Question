class Solution {
    // A map to store the digit to letter mapping
    private static final Map<Character, String> digitToLetters = new HashMap<>();
    
    // Initialize the digit to letter mappings
    static {
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Edge case: if digits is empty, return an empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Start the backtracking process
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }
    
    // Backtracking function to generate combinations
    private void backtrack(List<String> result, StringBuilder currentCombination, String digits, int index) {
        // If the current combination has the same length as the digits, add it to the result
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }
        
        // Get the letters corresponding to the current digit
        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);
        
        // Loop over all the letters corresponding to the current digit
        for (char letter : letters.toCharArray()) {
            // Add the current letter to the combination
            currentCombination.append(letter);
            
            // Move on to the next digit
            backtrack(result, currentCombination, digits, index + 1);
            
            // Backtrack by removing the last letter
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}
