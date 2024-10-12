class Solution {
    public boolean repeatedSubstringPattern(String s) {
       String str = s+s;
        String modified = str.substring(1,str.length()-1);
        return modified.contains(s);
    }
}