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
    public int deepestLeavesSum(TreeNode root) {
        int[] res = new int[2];
        dfs(root,0,res);
        return res[1];
    }
    private void dfs(TreeNode root, int level, int[] res){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(level == res[0]){
                res[1] += root.val ;
            }
            if(level > res[0]){
                res[0] = level;
                res[1] = root.val;
            }
            return;
        }

        dfs(root.left, level+1, res);
        dfs(root.right, level+1, res);
    }
}
