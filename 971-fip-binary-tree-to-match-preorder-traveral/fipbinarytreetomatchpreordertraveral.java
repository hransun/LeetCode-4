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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        //pre-order traversal
        List<Integer> list = new ArrayList<>();
        int[] index = new int[]{0};
        if(preOrder(root, voyage, index, list)){
              return list;
        }
        List<Integer> res = new ArrayList<>();
        res.add(-1);
        return res;

    }
    private boolean preOrder(TreeNode root, int[] array, int[] index, List<Integer> list){
        if(root == null){
            return true;
        //cur node not equal
            //index 指向cur node
        } else if(root.val != array[index[0]]){
            return false;
        }
        //move index and check cur node's leftchild
        //if not eqaul, swap with right child
        //move to the next level
        index[0] += 1;
        if(root.left != null && root.left.val != array[index[0]]){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            list.add(root.val);
        }
        return preOrder(root.left, array, index, list) && preOrder(root.right, array, index,list);
    }
}
