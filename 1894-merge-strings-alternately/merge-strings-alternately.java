class Solution {
    public String mergeAlternately(String word1, String word2) {
       int i=0;
        StringBuilder str  = new StringBuilder();
        for( i=0;i<Math.min(word1.length(),word2.length());i++){
            str.append(word1.charAt(i));
            str.append(word2.charAt(i));
        }
        if(word1.length()>word2.length()){
            for(;i<word1.length();i++){
                str.append(word1.charAt(i));
            }
        }
        else{
             for(;i<word2.length();i++){
                str.append(word2.charAt(i));
            }
        }
       
        return str.toString();
        }
        

    }
