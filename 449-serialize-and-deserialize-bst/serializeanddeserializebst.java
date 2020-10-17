* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/
public class Codec {

   // Encodes a tree to a single string.
   //be careful, each element has to be separed by " "
   //otherwise, the decoder will be wrong, ie: 54 will be decoder to 5 and 4
     public String serialize(TreeNode root) {
       StringBuilder[] sb = new StringBuilder[1];
       sb[0] = new StringBuilder();
       helper(root, sb);
       return sb[0].toString();
   }
   private void helper(TreeNode root, StringBuilder[] sb){
       if(root == null){
           return;
       }
       sb[0].append(root.val);
       sb[0].append(" ");
       helper(root.left, sb);
       helper(root.right, sb);
   }

   // Decodes your encoded data to tree.
   public TreeNode deserialize(String data) {
       if(data == null || data.length() == 0){
           return null;
       }
       String[] array = data.split(" ");
       return helper(array, 0, array.length-1);
   }
   private TreeNode helper(String[] array, int left, int right){
      if(left > right){
          return null;
      }
      TreeNode root = new TreeNode(Integer.valueOf(array[left]));
      int k = left+1;
       while(k <= right && Integer.valueOf(array[k]) < Integer.valueOf(array[left])){
           k++;
       }
      root.left = helper(array, left+1, k-1);
      root.right = helper(array, k,right);
       return root;
   }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
