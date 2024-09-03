class Solution {
    public void rotate(int[] nums, int k) {
        // Ensure k is within the bounds of the array length
        k = k % nums.length;
        
        // Temporary array to store the last k elements
        int[] temp = new int[k];

        // Step 1: Store the last k elements in the temp array
        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }

        // Step 2: Shift the remaining elements to the right by k positions
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        // Step 3: Place the temp elements at the beginning of the array
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
