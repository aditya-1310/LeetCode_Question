class Solution {
    public boolean isValid(String s) {
       if(s.length() %2 !=0) return false;
       HashMap<Character,Character> map = new HashMap<>();
       map.put(')','(');
       map.put('}','{');
       map.put(']','[');

       Stack<Character> st = new Stack<>();
       for(int i=0;i<s.length();i++){
        char sh = s.charAt(i);
        if(!map.containsKey(sh)){
            st.push(sh);
        }
        else if(st.isEmpty()|| map.get(sh)!=st.pop()){
            return false;
        }
       }
       return st.isEmpty();
    }
}