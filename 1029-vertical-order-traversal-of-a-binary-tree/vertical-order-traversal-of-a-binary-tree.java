/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair implements Comparable<Pair>{
        TreeNode node;
        int verLevel;
        Pair(){}
        Pair(TreeNode node,int verLevel){
            this.node = node;
            this.verLevel = verLevel;
        }
        public int compareTo(Pair obj){
            Pair other = obj;
            if(this.verLevel!=other.verLevel) return -(other.verLevel-this.verLevel);

            return -(other.node.val-this.node.val);
        }
    }
    int min = 0;
    int max = 0;

    public void dfs(TreeNode root, int pos){
        if(root==null) return;

        min = Math.min(min,pos);
        max = Math.max(max,pos);

        dfs(root.left,pos-1);
        dfs(root.right,pos+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0);

        List<List<Integer>> res = new ArrayList<>();
        int size = (max - min) + 1;
        for(int i = 0;i<size;i++){
            res.add(new ArrayList<>());
        }
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(root,Math.abs(min)));

        while(q.size()>0){
            int currSize = q.size();
            PriorityQueue<Pair> childq = new PriorityQueue<>();
            while(currSize-->0){
                Pair rem = q.remove();
                res.get(rem.verLevel).add(rem.node.val);
                if(rem.node.left!=null){
                    Pair left = new Pair(rem.node.left,rem.verLevel-1);
                    childq.add(left);
                }
                if(rem.node.right!=null){
                    Pair right = new Pair(rem.node.right,rem.verLevel+1);
                    childq.add(right);
                }
            }
            q = childq;
        }
        return res;
    }
}