class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int ar [] = new int[queries.length];
        int j =0; 
        for(int []qu : queries){
            int xor = arr[qu[0]];
            for(int i=qu[0]+1;i<=qu[1];i++){
             xor = xor^arr[i];
            }
            ar[j] = xor;
             j++;
        }
        return ar;
    }
}