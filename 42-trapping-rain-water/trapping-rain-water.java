class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int []p= new int [n];
        int []s= new int [n];
        p[0] = height[0];
        for(int i=1;i<n;i++){
           p[i] = Math.max(p[i-1],height[i]);
        }
        s[n-1] = height[n-1];
        for(int j=n-2;j>=0;j--){
            s[j] = Math.max(s[j+1],height[j]);
        }
            int r =0;
        for(int i =0;i<n;i++){
            r += Math.min(p[i],s[i]) - height[i];
        }


        return r;
    }
}