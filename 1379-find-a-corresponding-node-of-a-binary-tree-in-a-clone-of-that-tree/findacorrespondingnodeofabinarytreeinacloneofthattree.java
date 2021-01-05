class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null){
            return null;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if(original.equals(target)){
            return cloned;
        }
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        return left == null? right:left;
    }
}
