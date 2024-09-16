class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int []> pr = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int n = nums.length;
        int ans[] = new int[n-k+1];
        for(int i=0;i<k;i++) pr.add(new int[]{nums[i],i});

        ans[0] = pr.peek()[0];
        for(int i=k;i<n;i++){
            pr.add(new int[]{nums[i],i});
        while(pr.peek()[1]<=i-k){
            pr.poll();
        }
            ans[i-k+1 ]=pr.peek()[0];
        }

        return ans;
    }

}