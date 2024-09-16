class Solution {
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> fir = new ArrayList<>();
        fir.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(!isanagrams(words[i],words[i-1])){
                fir.add(words[i]);
            }
        }
        return fir;
    }
    public boolean isanagrams(String s1, String s2){
        char char1[] = s1.toCharArray();
        char char2[] = s2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);

        return Arrays.equals(char1,char2);
    }
}