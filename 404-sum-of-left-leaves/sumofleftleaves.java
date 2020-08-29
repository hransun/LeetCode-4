class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        boolean leftNode = false;
        return helper(root, leftNode);
    }
    private int helper(TreeNode root, boolean leftNode) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null) {
            if(leftNode) {
                 return root.val;
            }
            return 0;

        }
        leftNode = true;
        int s1 = helper(root.left, leftNode);
        leftNode = false;
        int s2 = helper(root.right, leftNode);
        return s1+s2;
    }
}
