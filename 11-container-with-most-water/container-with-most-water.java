class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i =0;
        int j= n-1;
        int maxwater =0;
        while(i<j){
            int w = j-i;
            int h = Math.min(height[i],height[j]);
            int ans = w*h;
            maxwater = Math.max(maxwater,ans);
            if(height[i]<height[j]) i++;
            else j--;
        }
        return maxwater;
    }
}