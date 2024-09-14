class Solution {
    public long smallestNumber(long num) {
        if(num>0){
            String ss = Long.toString(num);
            char charr[] = ss.toCharArray();
            Arrays.sort(charr);
            if(charr[0] =='0'){
                for(int i=0;i<charr.length;i++){
                    if(charr[i]-'0'!=0){
                        char temp = charr[0];
                        charr[0] = charr[i];
                        charr[i] = temp;
                        break;
                    }
                }

            }
           return Long.parseLong(new String(charr));
        }
        else{
            String nn = Long.toString(-num);
            char ch[] = nn.toCharArray();
            Arrays.sort(ch);
            StringBuilder sr = new StringBuilder(new String(ch));
            sr.reverse();
            return -Long.parseLong(sr.toString());
        }
    }
}