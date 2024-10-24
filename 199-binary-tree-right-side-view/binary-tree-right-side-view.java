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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        if(root == null) return arr;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i=0;i<size;i++){
            TreeNode curr = pq.poll();
                if(i==size-1) {
                    arr.add(curr.val);
                }
                if(curr.left!=null) pq.add(curr.left);
                if(curr.right!=null) pq.add(curr.right);
            }
        }

        return arr;
    }
}