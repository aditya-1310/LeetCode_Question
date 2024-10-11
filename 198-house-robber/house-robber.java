class Solution {
    int t[] = new int[101];
    public int rob(int[] nums) {
        int n = nums.length;
            Arrays.fill(t,-1);
       
        return solve(nums,0,n);
    }
    public int solve(int []nums,int i,int n){
            if(i>=n) return 0;
            if(t[i]!=-1) return t[i];
        int take  = nums[i]+solve(nums,i+2,n);
        int skip = solve(nums,i+1,n);

        return t[i] =  Math.max(take,skip);
    }
}