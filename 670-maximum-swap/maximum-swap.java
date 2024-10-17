class Solution {
    public int maximumSwap(int num) {
    // Convert the number into a character array to work with each digit.
    char[] digits = Integer.toString(num).toCharArray();
    
    // Create an array to store the last occurrence of each digit (0-9).
    int[] last = new int[10];
    for (int i = 0; i < digits.length; i++) {
        last[digits[i] - '0'] = i;
    }

    // Iterate through each digit from left to right.
    for (int i = 0; i < digits.length; i++) {
        // Check if there is a larger digit that can be swapped with the current one.
        // Start from 9 down to the current digit + 1 to maximize the swap.
        for (int d = 9; d > digits[i] - '0'; d--) {
            // If a larger digit `d` exists and appears after index `i`, swap them.
            if (last[d] > i) {
                // Perform the swap.
                char temp = digits[i];
                digits[i] = digits[last[d]];
                digits[last[d]] = temp;
                
                // Convert the character array back to an integer and return the result.
                return Integer.parseInt(new String(digits));
            }
        }
    }

    // If no swap was performed, return the original number.
    return num;
}

}