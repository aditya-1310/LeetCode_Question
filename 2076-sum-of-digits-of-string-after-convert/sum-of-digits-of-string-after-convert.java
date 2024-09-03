class Solution {
    public int getLucky(String s, int k) {
        int sum=0;
        String s1 = "";
        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            s1+=((int)arr[i]-96);
        }

        char[] arr2 = new char[s1.length()];
        arr2 = s1.toCharArray();
        for(int i=0;i<arr2.length;i++){
            sum+=((int)arr2[i]-48);
        }

        for(int i =0;i<(k-1);i++){
            int n = sum;
            sum=0;
            while(n>0){
                sum+=(n%10);
                n/=10;
            }
        }

        return sum;
    }
}