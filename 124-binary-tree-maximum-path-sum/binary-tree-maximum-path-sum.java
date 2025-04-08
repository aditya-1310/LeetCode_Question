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
    public int maxPathSum(TreeNode root) {
        int arr[] = new int[1];
        arr[0] = Integer.MIN_VALUE;
             maxvalue(root,arr);
            return arr[0];
    }
    public int maxvalue(TreeNode root, int[] arr){
        if(root == null)  return 0;
        int left = Math.max(0,maxvalue(root.left,arr));
        int right = Math.max(0,maxvalue(root.right,arr));
        arr[0] = Math.max(arr[0],left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}