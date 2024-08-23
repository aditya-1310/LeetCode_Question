class Solution {
    public void setZeroes(int[][] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0){
                    for(int r=0;r<arr.length;r++ ){
                        if(arr[r][j]!=0) 
                        {
                        arr[r][j]=690000;
                        }
                    }
                    for(int u=0;u<arr[0].length;u++ ){
                        if(arr[i][u]!=0){
                        arr[i][u]=690000;
                        }
                    }
                }
            }
        }
         for(int i=0;i<arr.length;i++){  
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==690000 ){
                    arr[i][j]=0;
                }
                
                System.out.print(arr[i][j]+" ");
            
            }
            System.out.println();
        }
    }
}