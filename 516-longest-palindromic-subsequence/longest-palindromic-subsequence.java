class Solution {
    int [][]t = new int [1001][1001];
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        s1= new StringBuilder(s).reverse().toString();
        int m  = s1.length();
        for(int i=0;i<t.length;i++){
            Arrays.fill(t[i],-1);
        }
        return LCS(s,s1,m,m);
    }
    public int LCS(String s,String s1,int i ,int j){
        if(i== 0 || j ==0 ) return t[i][j]=0;

        if(t[i][j]!=-1) return t[i][j];

        if(s.charAt(i-1)==s1.charAt(j-1)) return 1+LCS(s,s1,i-1,j-1);

        return t[i][j] = Math.max(LCS(s,s1,i-1,j),LCS(s,s1,i,j-1));    
    }
}