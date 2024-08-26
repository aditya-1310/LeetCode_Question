class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = grid[i][j]==1?-1:Integer.MAX_VALUE;
            }
        }

        grid[0][0] = 1;
        int drow[][] = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();

        row.offer(0);
        col.offer(0);

        int ans = Integer.MAX_VALUE;
        while(!row.isEmpty()){
         int roww = row.poll();   
         int coll = col.poll();
            if(roww ==n-1 && coll == n-1){
                ans = Math.min(grid[roww][coll],ans);
            }
            for(int i=0;i<8;i++){
                int newr = drow[i][0]+roww;
                int newc = drow[i][1]+coll;
                if(newr>=0 && newr<n && newc>=0 && newc<n && grid[newr][newc]!=-1){
                    if(grid[newr][newc]> grid[roww][coll]+1){
                        grid[newr][newc] = grid[roww][coll]+1;
                        row.offer(newr);
                        col.offer(newc);
                    }
                }
            }
        }


        return ans == Integer.MAX_VALUE?-1:ans;
    }
}