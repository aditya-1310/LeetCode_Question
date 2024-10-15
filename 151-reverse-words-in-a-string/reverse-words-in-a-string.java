class Solution {
    public String reverseWords(String s) {
        String word[] = s.trim().split("\\s+");
        StringBuilder str = new StringBuilder();
        for(int i=word.length-1;i>=0;i--){
            str.append(word[i]);
            if(i!=0){
                str.append(" ");
            }
        }


        return str.toString();
    }
}