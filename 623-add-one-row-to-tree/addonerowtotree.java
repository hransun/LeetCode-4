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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        //List<TreeNode> prev = new List<>();
        int depth = 1;
        if(d-1==0){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> cur = new ArrayDeque<>();
        cur.add(root);
        while(depth < d-1){
           // prev.clear();
            int size = cur.size();
            for(int i = 0; i < size; i++){
                TreeNode node = cur.poll();
                //prev.add(cur.poll())
                if(node.left != null){
                    cur.offer(node.left);
                }
                if(node.right != null){
                    cur.offer(node.right);
                }
            }
            depth++;
        }
        while(!cur.isEmpty()){
            TreeNode node = cur.poll();
            TreeNode left = node.left;
            node.left = new TreeNode(v);
            node.left.left  = left;
            TreeNode right = node.right;
            node.right = new TreeNode(v);
            node.right.right = right;

        }
        return root;
    }
}
