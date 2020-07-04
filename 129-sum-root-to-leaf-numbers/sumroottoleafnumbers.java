class Solution {
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[]{0};
        if(root == null) {
            return sum[0];
        }
        helper(root, sum, 0);
        return sum[0];
    }
    private void helper(TreeNode root, int[] sum, int cur) {
        if(root == null) {
            return;
        }
        cur = (cur*10 + root.val);
        if(root.left == null && root.right == null) {
            sum[0] += cur;
            return;
        }
        helper(root.left, sum,cur);
        helper(root.right, sum, cur);

    }
}
