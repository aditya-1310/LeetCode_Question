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
    public boolean isCompleteTree(TreeNode root) {
        boolean isnull = false;
        if(root == null ) return true;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        while(!pq.isEmpty()){
        TreeNode curr = pq.poll();
        if(curr == null) isnull = true;
        else{
            if(isnull){
            return false;

            }
        pq.add(curr.left);
        pq.add(curr.right);
        } 

        }

        return true;
        }
    }
