class Solution {
    public boolean isSubsequence(String t, String s) {
        int i =0;
        int j=0;
        while(i<t.length() && j<s.length()){
            if(t.charAt(i)==s.charAt(j)){
                i++;
            }
            j++;
        }
        return i==t.length();
    }
}