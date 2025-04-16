class Solution {
    public String longestPalindrome(String s) {
        int val =0;String ma ="";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(ispalindrome(i,j,s)){

                    if(val < s.substring(i,j+1).length()){
                        ma = s.substring(i,j+1);
                    }
                    val = Math.max(val,s.substring(i,j+1).length());
                }
            }
        }

        return ma.length()==0?s.substring(0,1):ma;
    }
    public boolean ispalindrome(int i ,int j ,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}