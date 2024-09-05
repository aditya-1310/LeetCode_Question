class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum =0;
        for(int i=0;i<rolls.length;i++){
            sum +=rolls[i];
        }
       int val = mean*(rolls.length+n) - sum;
        if(val > 6*n || val<n ) return new int[0];
        int arr [] = new int[n];
        int base = val/n;
        int incre = val%n;
        Arrays.fill(arr,base);
        for(int i=0;i<incre;i++){
            arr[i]++;
        }
        return arr;
    } 
}