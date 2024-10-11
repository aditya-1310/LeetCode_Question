class Solution {
    int m;int n;
    int t[][] =new int [1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
             m= text1.length();
             n = text2.length();
             for(int i=0;i<t.length;i++){
                Arrays.fill(t[i],-1);
             }

        return solve(text1,text2 , 0 ,0);
    }
    public int solve(String s1,String s2,int i , int j){
        if(i>= m || j>= n){
            return 0;
        }
        if(t[i][j]!=-1) {
            return t[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return t[i][j] =  1+solve(s1,s2,i+1,j+1);
        }

    
        return t[i][j] =  Math.max(solve(s1,s2,i+1,j),solve(s1,s2,i,j+1));
        
    }
}