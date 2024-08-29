class Solution {
    public int removeStones(int[][] stones) {
       Set<int []> s = new HashSet<>();
       int ctn=0;
       for(int stone[] : stones){
       if(!s.contains(stone)){
        dfs(stones,stone,s);
        ctn++;
       }

       }
       return stones.length-ctn;
    }

    public void dfs(int[][]stones,int [] current,Set<int []>s){
        s.add(current);

        for(int []stone:stones){
            if(!s.contains(stone)){

                if(stone[0]==current[0] || stone[1] == current[1]){
                    dfs(stones,stone,s);
                }
            }
        }
    }
}
