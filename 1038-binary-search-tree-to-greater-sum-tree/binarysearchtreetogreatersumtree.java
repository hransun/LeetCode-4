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
    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int sum = 0;
        TreeNode cur = root;
        while(cur != null){
            stack.offerFirst(cur);
            cur = cur.right;
        }
        while(!stack.isEmpty()){
            cur = stack.pollFirst();
            //update the value of cur
            cur.val = cur.val+sum;
            sum = cur.val;
            cur = cur.left;
            while(cur != null){
                stack.offerFirst(cur);
                cur = cur.right;
            }

        }
        return root;
    }
}
