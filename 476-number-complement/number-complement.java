class Solution {
    public int findComplement(int number) {
         StringBuilder binary = new StringBuilder();
       while(number>0){
           int rem  = number %2;
           binary.insert(0,rem);
           number /=2;
           
       }
      for(int i=0;i<binary.length();i++){
          if(binary.charAt(i)=='0') binary.setCharAt(i,'1');
          else{
              binary.setCharAt(i,'0');
          }
      }
       int j=0; int inte=0;
       for(int i=binary.length()-1;i>=0;i--){
           inte += Math.pow(2,j)*(binary.charAt(i)-'0');
           j++;
       }
      return inte;
    }
}