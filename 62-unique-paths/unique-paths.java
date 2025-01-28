class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m+1][n+1];
            arr[0][0] = 1;
            int result =0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i==0 && j==0 ) continue;
                    int top=0; 
                    int left =0;
                    
                    if(i-1>=0) top =arr[i-1][j];

                    if(j-1>=0) left = arr[i][j-1]; 
                    arr[i][j] = top +left;
                }

            }


            return arr[m-1][n-1];
    }
}