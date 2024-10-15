class Solution {
    public String reverseVowels(String s) {
        char str[] = s.toCharArray();
       String vowels = "aeiouAEIOU";
            int i=0;
            int j =s.length()-1;
        while(i<j){
            while(i<j && vowels.indexOf(str[i])==-1){
                i++;
            }
            while(i<j && vowels.indexOf(str[j])==-1){
                j--;
            }
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }

        String ans = new String(str);
        return ans;
    }
}