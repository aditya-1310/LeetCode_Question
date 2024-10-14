class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse the digits array from the last element to the first
        for (int i = n - 1; i >= 0; i--) {
            // Increment the current digit by one
            digits[i]++;
            
            // If the result is less than 10, no carry is needed
            if (digits[i] < 10) {
                return digits;
            }
            
            // If the result is 10, set the current digit to 0 and carry the 1
            digits[i] = 0;
        }
        
        // If all digits were 9 and we have a carry left, we need a new array
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
