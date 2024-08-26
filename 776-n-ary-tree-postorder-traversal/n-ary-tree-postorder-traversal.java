/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null) return arr;
       traversal(root,arr);

        return arr;
    }

    public void traversal(Node curr, List<Integer> arr){
        if(curr == null) return ;

        for(Node vaal : curr.children){
            traversal(vaal,arr);
        }

        arr.add(curr.val);
    }
}