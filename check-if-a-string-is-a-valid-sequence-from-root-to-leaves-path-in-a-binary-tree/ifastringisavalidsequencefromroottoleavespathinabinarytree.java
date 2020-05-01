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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        //T: O(index) S: O(index)
        if(root == null || arr == null || arr.length == 0) {
            return false;
        }
        return helper(root, arr, 0);
    }
    private boolean helper(TreeNode root, int[] arr, int index) {
        if(index == arr.length -1) {
            if(root != null && root.val == arr[index] && root.left == null && root.right == null) {
                return true;
            }
            return false;
        }
        if(root != null && root.val == arr[index]){
            if(helper(root.left, arr,index+1) || helper(root.right, arr, index+1)) {
                return true;
            }
        }
        return false;
    }
}
