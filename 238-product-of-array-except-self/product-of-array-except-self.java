class Solution {
    public int[] productExceptSelf(int[] nums) {
        int main =1;
        int zerocount =0;

        int prowzero=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zerocount++;
            main *= nums[i];
            if(nums[i]!=0){
                prowzero*=nums[i];
            }
        }

        int arr [] = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            if(zerocount<1){
                arr[i] = main/nums[i];
            }else{
                if(zerocount==1 && nums[i]==0){
                    arr[i] = prowzero;
                }
                else{
                    arr[i] =0;
                }
            }
        }

        return arr;
    }
}