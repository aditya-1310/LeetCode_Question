class Solution {
    public int removeStones(int[][] stones) {
        // To track visited stones
        Set<int[]> visited = new HashSet<>();
        int numOfIslands = 0;

        for (int[] stone : stones) {
            if (!visited.contains(stone)) {
                dfs(stones, stone, visited);
                numOfIslands++;
            }
        }

        // Total stones minus the number of islands gives the number of stones that can be removed
        return stones.length - numOfIslands;
    }

    private void dfs(int[][] stones, int[] current, Set<int[]> visited) {
        visited.add(current);

        for (int[] stone : stones) {
            if (!visited.contains(stone)) {
                // Stones share the same row or column
                if (stone[0] == current[0] || stone[1] == current[1]) {
                    dfs(stones, stone, visited);
                }
            }
        }
    }
}
