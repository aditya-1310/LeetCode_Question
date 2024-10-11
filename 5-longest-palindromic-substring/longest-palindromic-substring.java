class Solution {
    boolean t[][] = new boolean[1001][1001];
    public String longestPalindrome(String s) {
        for(int i=0;i<t.length;i++){
            Arrays.fill(t[i],false);
        }
        int max = 1;
      
        int start =0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(ispalindrom(s,i,j)){
                   int len =j-i+1;
                   if(len>max){
                    max = len;

                    start  =i;
                   }
                }
            }
        }
            return  s.substring(start,start+max);
    }
    public boolean ispalindrom(String s , int i , int j){
        if(i>=j){
            return true;
        }

        if(t[i][j]) return true;

        if(s.charAt(i) == s.charAt(j)){
            return   t[i][j] = ispalindrom(s,i+1,j-1);
        }
        else{
            t[i][j] =false;
        }

        return t[i][j];
    }
}