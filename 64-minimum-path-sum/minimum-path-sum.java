class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int arr[][] = new int[m+1][n+1];
        arr[0][0] =1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) {
                    arr[i][j] = grid[i][j];
                    continue;
                }
                int top =Integer.MAX_VALUE;
                if(i-1>=0) top = arr[i-1][j];

                int left =Integer.MAX_VALUE;
                if(j-1>=0) left = arr[i][j-1];

                arr[i][j] = grid[i][j] + Math.min(top,left);

            }
        }

        return arr[m-1][n-1];
    }
}