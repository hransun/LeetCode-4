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
    public int maxDepth(TreeNode root) {
        int[] res = new int[1];
        helper(root, res,0);
        return res[0];
    }
    private void helper(TreeNode root, int[] res, int cur){
        if(root == null){
            res[0] = Math.max(res[0], cur);
            return;
        }
        helper(root.left, res, cur+1);
        helper(root.right, res, cur+1);
    }
}
