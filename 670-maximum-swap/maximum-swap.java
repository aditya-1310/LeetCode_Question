class Solution {
    public int maximumSwap(int numm) {
        String s = Integer.toString(numm);
        int n = s.length();
      int rightmax [] = new int[n];
      rightmax[n-1] = n-1;
      for(int i=n-2;i>=0;i--){
        if(s.charAt(rightmax[i+1]) < s.charAt(i)){
            rightmax[i] = i;
        }
        else{
            rightmax[i] = rightmax[i+1];
        }
      }

      for(int i=0;i<n;i++){
        if(s.charAt(i)< s.charAt(rightmax[i])){
        char arr[] = s.toCharArray();
           char temp = arr[i];
           arr[i] = arr[rightmax[i]];
           arr[rightmax[i]]=temp;
           return Integer.parseInt(new String(arr));
        }
      }
      return numm;
    }
}