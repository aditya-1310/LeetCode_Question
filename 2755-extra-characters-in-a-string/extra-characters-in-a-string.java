class Solution {
    public int minExtraChar(String s, String[] dict) {
            HashSet<String> hash = new HashSet<>();
            for(String dic:dict) hash.add(dic);
            int n = s.length();
            int dp [] = new int[n+1];

            for(int i=n-1;i>=0;i--){
                dp[i] = 1+dp[i+1];

                for(int j=i;j<n;j++){
                    String curr = s.substring(i,j+1);
                    if(hash.contains(curr)){
                        dp[i] = Math.min(dp[i],dp[j+1]);
                    }
                }
            }
            return dp[0];

            // int result = solve(0,s,hash);
            // return result;
    }
    // public int solve(int st,String s, HashSet<String> hash){
    //     if(st>=s.length()) return 0;

    //     int res = 1+solve(st+1,s,hash);

    //     for(int j=st;j<s.length();j++){
    //         String curr = s.substring(st,j+1);
    //         if(hash.contains(curr)){
    //             res = Math.min(res,solve(j+1,s,hash));
    //         }
    //     }
    //     return res;
    // } getting TLE
    
}