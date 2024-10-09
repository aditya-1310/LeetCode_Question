class Solution {
    public boolean judgeCircle(String s) {
        int u =0,d =0,l=0,r=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='U'){
                u++;
            }
            else if(ch=='D') d++;
            else if(ch=='L') l++;
            else if(ch=='R') r++;


        }
            if(u-d==0 && r-l==0) return true;
        return false; 
    }
}