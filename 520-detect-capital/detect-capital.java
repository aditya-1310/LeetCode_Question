class Solution {
    public boolean detectCapitalUse(String word) {
        if(allcap(word) || allsmall(word) || allsmall(word.substring(1,word.length()))){
            return true;
        }
        return false;
    }
    public boolean allcap(String word){
        for (char ch :word.toCharArray()){
            if(ch<'A' || ch>'Z'){

                return false;
            }
        }
            return true;
    }
    public boolean allsmall(String word){
        for (char ch :word.toCharArray()){
            if(ch<'a' || ch>'z'){

                return false;
            }
        }
            return true;
    }
}