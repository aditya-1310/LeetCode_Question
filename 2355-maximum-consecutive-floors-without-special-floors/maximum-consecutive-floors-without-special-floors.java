class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
      
        Arrays.sort(special);
        int diff = 0;
        for(int i=0;i<special.length-1;i++){
            diff = Math.max(diff,special[i+1]-special[i]);
        }
         int ans = Math.max((Math.abs(bottom-special[0])),(Math.max(diff-1,Math.abs(special[special.length-1]-top))));

        return ans;
    }
}