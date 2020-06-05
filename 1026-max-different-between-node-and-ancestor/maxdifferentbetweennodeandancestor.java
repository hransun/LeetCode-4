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
    public int maxAncestorDiff(TreeNode root) {
        // from top to down, keep the max and min value
        // each recrusive level, update the max/min res
        //dfs(top to down)
        //base case : return  max - min
        if(root == null) {
            return 0;
        }
        return dfs(root, root.val, root.val);
    }
    private int dfs(TreeNode root, int max, int min) {
        if(root == null) {
            return max - min;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(dfs(root.left, max, min), dfs(root.right, max,min));
    }
}
