class Solution {
    public int countPrimes(int n) {
        if(n<=1) return 0;
        boolean arr [] = new boolean[n];
        for(int i=2;i<n;i++){
            arr[i] = true;
        }

        for(int i=0;i*i<n;i++){
            if(arr[i]== true){
                for(int j=2*i;j<n;j=j+i){
                    arr[j]=false;
                }
            }
        }
        int ctn =0;
        for(int i=0;i<n;i++){
            if(arr[i]==true) {
                ctn++;
            }
        }

       return ctn;

    }
}
