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
    public int pathSum(TreeNode root, int sum) {
        int[] res = new int[1];
        List<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(0);
        helper(root,0,sum, prefixSum, res);
        return res[0];
    }
    private void helper(TreeNode root, int sum, int target, List<Integer> prefixSum, int[] res) {
        if(root == null){
            return;
        }
        sum += root.val;

        for(int temp: prefixSum) {
            if(temp == (sum-target)) {
                 res[0] += 1;
            }

        }
        prefixSum.add(sum);
        helper(root.left, sum, target, prefixSum, res);
        helper(root.right, sum, target, prefixSum, res);
        prefixSum.remove(prefixSum.size()-1);
    }
}
