class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int ex) {
        ArrayList<Boolean> arr = new ArrayList<>();
        int sum =0;
        for(int i:candies){
            sum  = Math.max(sum,i);
        }
        for(int i=0;i<candies.length;i++){
            int val = candies[i];
            if(val+ex>=sum){
                arr.add(true);
            }
            else{
                arr.add(false);
            }
        }
        return arr;
    }
}