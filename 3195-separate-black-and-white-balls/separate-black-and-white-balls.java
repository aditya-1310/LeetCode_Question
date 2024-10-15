class Solution {
    public long minimumSteps(String ss) {
       long total =0;
       long white =0;
       for(int i=0;i<ss.length();i++){
        if(ss.charAt(i)=='0'){
            total += i -white;

            white++;
        }
       }

       return total;
    }
}