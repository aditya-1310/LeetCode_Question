class Solution {
    public String largestNumber(int[] nums) {
        String str[] = new String[nums.length];
        for(int i=0;i<str.length;i++){
            str[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(str,(a,b)->(b+a).compareTo(a+b));

        if(str[0].equals("0")) return "0";


        StringBuilder st  = new StringBuilder();
        for(String s :str){
            st.append(s);
        }
        return st.toString();
    }
}