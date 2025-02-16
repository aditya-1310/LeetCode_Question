class Solution {
    class Node{
        List<String> data;
        Node children[];
        boolean eow ;
        Node(){
            children = new Node[26];
            data = new ArrayList<>();
            eow = false;
        }
    }
        static Node root;
        List<List<String>> ans;
    public List<List<String>> groupAnagrams(String[] strs) {
        root = new Node();
        ans = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            Node temp= root;
            String smm = strs[i];
            char chs[] = smm.toCharArray();
            Arrays.sort(chs);
            for(char ch:chs){
                Node child = temp.children[ch -'a'];
                if(child == null) {
                    temp.children[ch - 'a'] = new Node();
                }
                    temp  = temp.children[ch - 'a'];
            }
            temp.eow = true;
            temp.data.add(smm);
        }
        dfs(root);

        return ans;

    }
    public void dfs(Node root){
        if(root.eow){
            ans.add(root.data);
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null)
            dfs(root.children[i]);
        }
    } 
}