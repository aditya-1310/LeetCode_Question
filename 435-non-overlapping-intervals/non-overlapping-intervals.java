class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int ctn =0;int ff=0,ll=0,rl=Integer.MIN_VALUE;
        Arrays.sort(intervals,(a,b)->{
            if(a[1] == b[1]) {
                return Integer.compare(a[0],b[0]);
            }else{
                return Integer.compare(a[1],b[1]);
            }
        });
        for(int i=0;i<n;i++){
             ff = intervals[i][0];
             ll = intervals[i][1];
            if(ff<rl){
                ctn++;
            }else{
             rl = ll;

            }
        }

        return ctn;
    }
}