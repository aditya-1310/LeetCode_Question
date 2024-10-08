class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0) return false;
        int ctn =0;int flexible=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(locked.charAt(i)=='1'){
                if(ch=='('){
                    ctn++;
                }else{
                    ctn--;
                }
            }
            else{
                flexible++;
            }
        if(ctn < -flexible) return false;
        }

          ctn =0; flexible=0;
         for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(locked.charAt(i)=='1'){
                if(ch==')'){
                    ctn++;
                }else{
                    ctn--;
                }
            }
            else{
                flexible++;
            }
     if(ctn < -flexible) return false;
        }
        return true;
    }
}