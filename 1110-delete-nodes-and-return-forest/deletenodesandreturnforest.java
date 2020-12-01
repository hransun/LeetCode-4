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
    //postorder: 先走左右子树，incase 左右子树有node要删除
    // 删除的node，左右子树都不为空，加入list
    //如果当前node不删除，node重新连接一下跟新过的左右子树，return
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(int i : to_delete){
            set.add(i);
        }
        List<TreeNode> res = new ArrayList<>();
        TreeNode newRoot = helper(root, set, res);
        //最后返回的新的root，也需要查看一下是不是空
        if(newRoot != null){
             res.add(newRoot);
        }
        return res;
    }
    private TreeNode helper(TreeNode root, Set<Integer> set, List<TreeNode> list){
        if(root == null){
            return null;
        }
        TreeNode left = helper(root.left, set, list);
        TreeNode right = helper(root.right, set, list);
        if(set.contains(root.val)){
            if(left != null){
                list.add(left);
            }
            if(right != null){
                list.add(right);
            }
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
