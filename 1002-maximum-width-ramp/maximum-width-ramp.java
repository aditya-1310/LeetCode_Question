class Solution {
    public int maxWidthRamp(int[] nums) {
        int result = 0; 
        int n = nums.length;
        int arr[] = new int[nums.length];
        
        arr[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            arr[i] = Math.max(nums[i],arr[i+1]);
         

        } 
        int j=0;int ramp =0;
       int i=0;
       while(j<n){
        
        while(i<j && nums[i]>arr[j]){
            i++;
        }
       ramp = Math.max(ramp,j-i);
       j++;
       }
 
       
        return ramp;
    }
}
