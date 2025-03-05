class Solution {
    public int longestOnes(int[] nums, int k) {
        int l =0;int r =0;int zerocount =0;int maxlen =0;

        while(r<nums.length){
            if(nums[r]==0){
                zerocount++;
            }
        

        while(zerocount > k){
            if(nums[l]==0){
                zerocount--;
            }
            l++;
        }
        

            int len = r-l+1;
            maxlen = Math.max(maxlen,len);
            r++;
        }


        return maxlen;
    }

  
    
}