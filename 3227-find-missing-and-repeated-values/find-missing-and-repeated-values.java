import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        // Count occurrences of numbers in grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mp.put(grid[i][j], mp.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        int a = 0, b = 0;
        
        // Find the repeated value
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == 2) {
                a = entry.getKey(); // The repeated number
                break;
            }
        }
        
        // Find the missing value
        for (int i = 1; i <= n * n; i++) {
            if (!mp.containsKey(i)) {
                b = i; // The missing number
                break;
            }
        }

        return new int[]{a, b};
    }
}
