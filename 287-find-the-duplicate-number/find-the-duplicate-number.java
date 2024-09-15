class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            int ctn =0;
            for(int num :nums){
                if(num <= mid)
                ctn++;
            }
            if(ctn >mid){
                right = mid;
            }
            else left = mid+1;
        }
        return left;
    }
}