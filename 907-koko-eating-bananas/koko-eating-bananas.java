class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;int high = getmax(piles);

        while(low<high){
            int mid = low + (high -low)/2;

            if(caneat(mid,piles,h)) {
            high = mid;
            } 

            else low  = mid +1;

        }
        return low;
    }

    public boolean caneat(int k , int []piles,int h){
        int hour =0;
        for(int pile:piles){
            hour+=(pile+k-1)/k;
        }

        return  hour<=h;
    }
    private int getmax(int piles[]){
        int max =Integer.MIN_VALUE;

        for(int pile :piles){
        max = Math.max(pile,max);
        }
        return max;
    }
}