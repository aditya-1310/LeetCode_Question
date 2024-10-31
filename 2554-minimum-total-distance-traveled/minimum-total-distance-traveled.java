class Solution {
   private long solve(List<Integer> robot, List<Integer> factoryPositions, int i, int j, int rsize, int fsize, long[][] dp) {
	if(i == rsize) return 0;
	if(j == fsize) return (long)1e12;
	if(dp[i][j] != -1) return dp[i][j];

	long repair = Math.abs(robot.get(i)-factoryPositions.get(j)) + solve(robot, factoryPositions, i+1, j+1, rsize, fsize, dp);
	long skip = solve(robot, factoryPositions, i, j+1, rsize, fsize, dp);

	return dp[i][j] = Math.min(repair, skip);
}

public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
	Collections.sort(robot);
	Arrays.sort(factory, (a,b)->a[0]-b[0]);
	List<Integer> factoryPositions = new ArrayList<>();
	for (int[] f : factory) {
		for (int i = 0; i < f[1]; i++) {
			factoryPositions.add(f[0]);
		}
	}
	long[][] dp = new long[robot.size()][factoryPositions.size()];
	for(long[] arr : dp) Arrays.fill(arr, -1);
	return solve(robot, factoryPositions, 0, 0, robot.size(), factoryPositions.size(), dp);
}
}