import java.util.Arrays;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks); // Sort ranks for efficiency
        long low = 1, high = (long) ranks[0] * (long) cars * (long) cars; 

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canRepairAll(ranks, cars, mid)) {
                high = mid; // Try a smaller time
            } else {
                low = mid + 1; // Increase time
            }
        }
        return low;
    }

    private boolean canRepairAll(int[] ranks, int cars, long time) {
        long count = 0;
        for (int rank : ranks) {
            count += Math.sqrt(time / rank);
            if (count >= cars) return true; // Stop early
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ranks = {4, 2, 3};
        int cars = 10;
        System.out.println(sol.repairCars(ranks, cars)); // Output: 16
    }
}
