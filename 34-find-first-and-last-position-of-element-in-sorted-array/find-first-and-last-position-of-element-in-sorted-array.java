class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int f  =  findFirstPosition(nums,target);
        int l  =  findLastPosition(nums,target);
        return new int[]{f,l};
    }
     private int findFirstPosition(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;
        int pos =-1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(nums[mid]==target) {
            pos = mid;
            right = mid -1;
            }
            else if(nums[mid]<target) left = mid+1;
            else {
            right = mid-1;
            } 
        }
        return pos;
    }
     private int findLastPosition(int[] nums, int target) {
        int left =0;
        int right=nums.length-1;
        int pos =-1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(nums[mid]==target) {
                pos = mid;
                left = mid+1;
            }
            else if(nums[mid]<target) left = mid+1;
            else{
                right = mid-1;
            }
        }
        return pos;
     }


}