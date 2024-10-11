class Solution {
    int t[] =new int[101];
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; 
        int n = nums.length;
        int[] farr = Arrays.copyOf(nums, nums.length - 1);
        int[] larr = Arrays.copyOfRange(nums, 1, nums.length);

        Arrays.fill(t,-1);
        int op1 = solve(farr,0,farr.length);
        Arrays.fill(t,-1);
        int op2 = solve(larr,0,larr.length);

        return Math.max(op1,op2);
    }
    public int solve(int nums[],int i,int n){
        if(i>=n){
            return 0;
        }
        if(t[i]!=-1) return t[i];

        int take  = nums[i]+solve(nums,i+2,n);
        int skip  = solve(nums,i+1,n);


        return t[i] = Math.max(take,skip);
    }
}