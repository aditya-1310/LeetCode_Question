class Solution {
    Map<Integer,Integer> mp = new HashMap<>() ;
    int dp[][];
  
    public boolean canCross(int[] stones) {
        if(stones[1]-stones[0]!=1) return false;

        for(int i=0;i<stones.length;i++){
            mp.put(stones[i],i);
        }
        dp = new int[stones.length][stones.length];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return solve(1,1,stones);
    }
    public boolean solve(int i,int k,int [] stones){
        if(i == stones.length-1){
            return true;
        }
    
    if(dp[i][k]!=-1){
        return dp[i][k] ==1;
    }
    boolean c1=false,c2=false,c3 = false;
       if( mp.containsKey(stones[i]+k)){
        c1 = solve( mp.get(stones[i]+k),k,stones);
       }
       if( k>1 && mp.containsKey(stones[i]+k-1)){
        c2 =  solve( mp.get(stones[i]+k-1),k-1,stones);
       }
       if(mp.containsKey(stones[i]+k+1)){
        c3 =  solve(mp.get(stones[i]+k+1),k+1,stones);
       }
        dp[i][k]  = (c1||c2||c3) ? 1 : 0;
        return dp[i][k] ==1;
    }
}