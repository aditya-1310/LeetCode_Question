class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
       long low = 1;long high = ranks[0] * (long) cars * (long) cars;
       while(low < high){
        long mid = low + (high-low)/2;

        if(canrepaire(mid,ranks,cars)){
            high = mid;
        }else{
            low = mid+1;
        }
       }
       return low;
        
    }
    public boolean canrepaire(long k , int ranks[], int cars){
        int value =0;

        for(int rank:ranks){
            value+= Math.sqrt(k/rank);
            if(value>=cars) return true;
        }
        return false;
    }
}