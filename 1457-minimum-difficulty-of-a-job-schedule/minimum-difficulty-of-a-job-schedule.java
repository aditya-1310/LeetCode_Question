class Solution {
    private int [][] t;
    public int minDifficulty(int[] jd, int d) {
            int n = jd.length;
            if(n<d) return -1;
            t = new int [n][d+1];
            for(int row[]:t){
                Arrays.fill(row,-1);
            }

            return solve(jd,n,0,d);
    }
    public int solve(int [] jd,int n,int idx,int d){
        if(d==1){
            return Arrays.stream(Arrays.copyOfRange(jd, idx, n)).max().orElse(Integer.MIN_VALUE);
        }
        if( t[idx][d] !=-1 ) return t[idx][d];
        int maxdiff = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;

        for(int i=idx;i<=n-d;i++){
            maxdiff  = Math.max(maxdiff,jd[i]);

            result = Math.min(result,maxdiff+solve(jd,n,i+1,d-1));

        }
        return t[idx][d] = result;
    }
}