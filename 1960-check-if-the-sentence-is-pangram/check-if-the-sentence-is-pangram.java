class Solution {
    public boolean checkIfPangram(String s) {
     HashMap<Character,Integer> map = new HashMap<>();
     for(char i:s.toCharArray()){
        map.put(i,map.getOrDefault(i,0)+1);
     }

     for(char ch = 'a';ch<='z';ch++){
        if(!map.containsKey(ch)) return false;
     }

     return true;
    }
}