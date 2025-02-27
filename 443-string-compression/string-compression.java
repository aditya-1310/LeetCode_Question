class Solution {
    public static int compress(char[] chars) {
       int w =0;int r=0;
       while(r<chars.length){
        char currentchar = chars[r];
        int ctn =0;

        while(r<chars.length && chars[r]==currentchar){
            r++;
            ctn++;
        }
        chars[w++] = currentchar;
         if (ctn > 1) {
                for (char c : String.valueOf(ctn).toCharArray()) {
                    chars[w++] = c;
                }
            }
       }

       return w;


    }
}