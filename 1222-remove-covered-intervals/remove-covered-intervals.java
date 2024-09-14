class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int prev[] = intervals[0];
        int ctn =0;
        for(int i=1;i<intervals.length;i++){
            int curr[] = intervals[i];
            if(curr[1]>prev[1]) {
                ctn++;
                prev = curr;
            }
        }
        return ctn +1;
    }
}