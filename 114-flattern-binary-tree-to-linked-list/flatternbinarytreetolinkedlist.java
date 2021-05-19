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
    public void flatten(TreeNode root) {
        root = helper(root);
    }
    private TreeNode helper(TreeNode root){
        if(root == null){
            return root;
        }
        TreeNode n1 = helper(root.left);
        TreeNode n2 = helper(root.right);
        root.right = n1;
        root.left = null;
        TreeNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        cur.right = n2;
        return root;
    }

}
