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
    //LCA变体，有多个nodes，如果找lca
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int[] height = new int[1];
        List<TreeNode> nodes = new ArrayList<>();
        getNodes(root, height, nodes,0);
        return LCA(root, nodes);

    }
    private void getNodes(TreeNode root, int[] height, List<TreeNode> nodes, int level){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(height[0] < level){
                nodes.clear();
                nodes.add(root);
                height[0] = level;
            }else if(height[0] == level){
                nodes.add(root);
            }
            return;
        }
        getNodes(root.left, height, nodes,level+1);
        getNodes(root.right, height, nodes, level+1);
    }
    private TreeNode LCA(TreeNode root, List<TreeNode> list){
        if(root == null || list.contains(root)){
            return root;
        }
        TreeNode left = LCA(root.left, list);
        TreeNode right = LCA(root.right, list);
        if(left != null && right != null){
            return root;
        }
        return left == null?right:left;
    }

}
