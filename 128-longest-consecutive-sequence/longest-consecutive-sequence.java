class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0) return 0;
        TreeSet<Integer> sett = new TreeSet<>();
        for(int i:nums){
            sett.add(i);
        }
        List<Integer> set = new ArrayList<>(sett);
        int ctn =0;
        int main =0;
        for(int i=0;i<set.size()-1;i++){
            if(set.get(i+1)-set.get(i)==1){
                ctn++;
            }
            else{
                ctn =0;
            }
            main = Math.max(main,ctn);
            }

            return main+1;
    }
}