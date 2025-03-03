class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] <pivot){
                arr.add(nums[i]);
            }
        }
        for(int i:nums){
            if(i == pivot){
                arr.add(i);
            }
        }
        for(int i :nums){
            if(i>pivot){
                arr.add(i);
            }
        }
        int ax [] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ax[i] = arr.get(i);
        }

        return ax;
    }
}