class Solution {
    public long dividePlayers(int[] arr) {
        Arrays.sort(arr);
        int i =0;
        int j =arr.length-1;
        long sum =0;
        int val = arr[0]+arr[arr.length-1];

        while(i<j){
            if(val == arr[i]+arr[j]){

        sum +=arr[i]*arr[j];
        j--;
        i++;
            }
            else{
                return -1;
            }
        }

        return sum;
    }
}