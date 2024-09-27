class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        solve(nums,0,arr);
        return arr;
    }
    public void solve(int[] nums,int index, List<List<Integer>> arr){
        if(index == nums.length){
            List<Integer> newarr = new ArrayList<>();
            for(int num:nums) newarr.add(num);

            arr.add(newarr);
            return ; 
        }

        for(int i=index;i<nums.length;i++){
            swap(nums,i,index);
            solve(nums,index+1,arr);
            swap(nums,index,i);
        }
    }
    public void swap(int arr[],int i,int index){
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}