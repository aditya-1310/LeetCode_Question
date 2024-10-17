class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(m!=n) return false;

        int feq1 [] = new int[26];
        int feq2 [] = new int[26];

        for(int i=0;i<n;i++){
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            feq1[ch1-'a']++;
            feq2[ch2-'a']++;
        }

        for(int i=0;i<26;i++){
            if(feq1[i] != 0 && feq2[i]!=0 || feq1[i]==0 && feq2[i]==0){
                continue;
            }

            return false;
        }
        Arrays.sort(feq1);
        Arrays.sort(feq2);
        return Arrays.equals(feq1,feq2);
    }
}