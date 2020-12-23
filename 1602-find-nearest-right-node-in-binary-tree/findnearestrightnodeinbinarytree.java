class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
      //level order tranversal
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur =queue.poll();
                if(cur.equals(u)){
                    return i+1==size? null: queue.poll();
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return null;
    }
}
