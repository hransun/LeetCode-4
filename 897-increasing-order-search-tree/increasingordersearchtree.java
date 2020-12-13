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
    public TreeNode increasingBST(TreeNode root) {
        //in-order traversal
        //prev: the prev node; here must use a variable, because root.left might not exist
        TreeNode[] newHead = new TreeNode[1];
        TreeNode[] prev = new TreeNode[1];
        helper(root, newHead, prev);
        return newHead[0];
    }
    private void helper(TreeNode root, TreeNode[] newHead, TreeNode[] prev){
        if(root == null){
            return;
        }
        helper(root.left, newHead, prev);
        if(prev[0] != null){
            //break the connection with left node, and connect wit prev node
            root.left = null;
            prev[0].right = root;
        }
        if(newHead[0] == null){
            newHead[0] = root;
        }
        //这里prev只要指向root就可以了，因为rightTree这里可能还有mostleftMostnode
        //下一轮需要prev和那个leftnode链接
        prev[0] = root;
        helper(root.right, newHead, prev);
    }
}
