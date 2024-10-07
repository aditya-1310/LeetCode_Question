class Solution {
    public int minLength(String s) {
       
        StringBuilder str = new StringBuilder(s);
       int val = solve(str);
       return val;
    }
    public int solve(StringBuilder s ){

        for(int i=0;i<s.length()-1;i++){

            if((s.charAt(i)=='A' && s.charAt(i+1)=='B') 
            || (s.charAt(i)=='C' && s.charAt(i+1)=='D'))    
            {
                s.delete(i,i+2);
                solve(s); 
            }

        }

            return s.length();
    }
}