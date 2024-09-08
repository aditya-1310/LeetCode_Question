class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
         HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map.putIfAbsent(i-j,new ArrayList<>());
                map.get(i-j).add(mat[i][j]);
            }
        }
         for(int key :map.keySet()){
            Collections.sort(map.get(key));
         }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=map.get(i-j).remove(0);
            }
        }

         return mat;
    }
}