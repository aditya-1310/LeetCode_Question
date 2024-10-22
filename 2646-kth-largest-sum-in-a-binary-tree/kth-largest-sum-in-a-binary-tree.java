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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        List<Long> arr = new ArrayList<>();
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        while(!pq.isEmpty()){
        long sum = 0;
            int size = pq.size();
            for(int i=0;i<size;i++){
            TreeNode node = pq.poll();
            sum += node.val;
            if(node.left!=null) pq.add(node.left);
            if(node.right!=null) pq.add(node.right);
            }
            arr.add(sum);
        }
         Collections.sort(arr, Collections.reverseOrder());
         return k>arr.size()?-1:arr.get(k-1);

    }
}