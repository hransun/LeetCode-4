class Solution {
    //T: O(n) S: O(height)
    public int kthSmallest(TreeNode root, int k) {
          if(root == null) {
               return -1;
          }
         Deque<TreeNode> stack = new ArrayDeque<>();
          pushNode(root,stack);
          int res = Integer.MIN_VALUE;
          for(int i = 0; i < k; i++) {
              TreeNode cur = stack.pollFirst();
              res = cur.val;
              if(cur.right != null) {
                  pushNode(cur.right, stack);
              }
          }
          return res;
      }
      private void pushNode(TreeNode root, Deque<TreeNode> stack) {
          while(root != null) {
              stack.offerFirst(root);
              root = root.left;
          }
      }

}
