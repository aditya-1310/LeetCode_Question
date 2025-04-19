class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int arr[][] = new int[m][n];
        if(obstacleGrid[0][0]!=1){
        arr[0][0] =1;
        } 
        for(int i=0;i<m;i++){
            
            for(int j =0 ;j<n;j++){
                if(i==0 && j ==0) continue;
                if(i==0 && obstacleGrid[0][j]!=1){
                arr[i][j] = arr[i][j-1];
                } 

                else if(j==0 && obstacleGrid[i][0]!=1) {
                    arr[i][0] =1;
                     arr[i][j] = arr[i-1][j];
                }

                else{
                    if(obstacleGrid[i][j]!=1){
                        arr[i][j] = arr[i-1][j] + arr[i][j-1];
                    }
                }
            }

        }
        return arr[m-1][n-1];
    }
}