class Solution {
    class  Node {
    Node [] children;
    boolean eow;
     Node(){
        children  = new Node[26];
        for(int i=0;i<26;i++){
            children[i] = null;
        }
        eow = false;
    }
}
  Node root = new Node(); 
  HashMap<String,Boolean> map = new HashMap<>();

    public void insert(String word){
            Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) -'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            if(i == word.length()-1){
                curr.children[idx].eow = true;
            }
             curr = curr.children[idx];
        }
    }
    public boolean serach(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) -'a';
            if(curr.children[index] == null) return false;

            if(i==word.length()-1 && curr.children[index].eow == false) return false;
            curr = curr.children[index];

        }
            return true;
    }


    public boolean wordBreak(String s, List<String> wordDict) {
            for(String st: wordDict){
                insert(st);
            }
            return fin(s);
    }
    public boolean fin(String word){
        if(word.length() ==0){
            return true;
        }
        if(map.containsKey(word)){
            return map.get(word);
        }
        for(int i=1;i<=word.length();i++){
            if(serach(word.substring(0,i)) && fin(word.substring(i))){
                map.put(word,true);
                return true;
            }


        }
        map.put(word,false);
            return false;
    }

}
