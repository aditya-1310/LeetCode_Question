class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        HashMap<Integer,Integer> mp  = new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                mp.put(grid[i][j],mp.getOrDefault(grid[i][j],0)+1);
            }
        }
        int a =0;int b=0;
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            if(entry.getValue()==2){
              a =  entry.getKey();
              break;
            }
        }
          for (int i = 1; i <= n * n; i++) {
            if (!mp.containsKey(i)) {
                b = i; 
                break;
            }
        }
        



        return new int[]{a,b};
    }
}