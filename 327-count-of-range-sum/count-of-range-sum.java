class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long prefix[] = new long [nums.length+1];

        for(int i=0;i<nums.length;i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        return solve(prefix,0,nums.length+1,lower,upper);
    }
    public int solve(long [] prefix,int start , int end, int lower, int upper){
        if(end-start <=1) return 0;
        int mid =   start+(end - start)/2;

        int count = solve(prefix,start,mid,lower,upper)
        + solve(prefix,mid,end,lower,upper);

        int j =mid,k = mid,t=mid;
        int r=0;
        long temp [] = new long[end - start];

        for(int i=start;i<mid;i++){
            while(k < end && prefix[k] - prefix[i] < lower ) k++;
            while(j < end && prefix[j] - prefix[i] <= upper ) j++;
            while(t < end && prefix[t] < prefix[i]) temp [r++] = prefix[t++];
            temp[r++] = prefix[i];
            count += j-k;



        }
        System.arraycopy(temp,0,prefix,start,t-start);
        return count;
    }
}