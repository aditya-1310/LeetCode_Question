class Solution {
    public int findKthNumber(int n, int k) {
        k-=1;
        int curr=1;
        while(k>0){
        int count = coun(curr,curr+1,n);
        if(count <= k){
            curr++;
            k-=count;
        }
        else{
            curr*=10;
            k-=1;
        }
        }
        return curr;
    }
    public int coun(long curr,long next,int n){
        int currsum =0;
        while(curr<=n){
            currsum += next-curr;
            curr*=10;
            next *=10;

            next=Math.min(next,(long)n+1);
        }
        return currsum;
    }

}