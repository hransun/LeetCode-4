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
    public int minCameraCover(TreeNode root) {
        int[] res = new int[]{0};
        //the root node is 0
        if(helper(root, res) == 0){
            return res[0]+1;
        }
        return res[0];
    }
    // the cur node: 0 : not cover， 1: cover or node is null, but not cam 2: cam
    private int helper(TreeNode root, int[] res){
        if(root == null){
            return 1;
        }
        int left = helper(root.left,res);
        int right = helper(root.right,res);
        //put the camere into cur node
        if(left == 0 || right == 0){
            res[0]++;
            return 2;
        }
        // cur node can't be cover
        if(left == 1 && right == 1){
            return 0;
        }
        // the cur node can be cover
        return 1;
    }
}
