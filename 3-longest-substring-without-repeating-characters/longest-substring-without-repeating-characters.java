class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[] = new int[256];
        int l =0;int r=0;int maxlen =0;
        Arrays.fill(hash,-1);
              for(int i=0;i<s.length();i++){
                if(hash[ s.charAt(i) ] != -1 ){
                    if(hash[s.charAt(i)] >= l){
                        l = hash[s.charAt(i)]+1;
                    }
                }

                hash[s.charAt(i)] = r;
                int len = r-l+1;
                maxlen = Math.max(maxlen, len);
                r++;
        }


        return maxlen;
    }
}