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
    public TreeNode str2tree(String s) {
        int[] index = new int[]{0};
        return helper(s, index);
    }
    private TreeNode helper(String s, int[] index){
        TreeNode node = null;
        int num = 1;
        while(index[0]< s.length()){
            char cur = s.charAt(index[0]);
            if(cur == '-'){
                num *= -1;
                index[0]++;
            }else if(cur == '('){
                index[0]++;
                if(node != null && node.left == null){
                    node.left = helper(s,index);
                }else if(node != null && node.right == null){
                    node.right = helper(s, index);
                }
            }else if(cur == ')'){
                index[0]++;
                return node;
            }
            else{
                //only digits
                int val = 0;
                while(index[0]< s.length() && Character.isDigit(s.charAt(index[0]))){
                    val = val*10 + (s.charAt(index[0]) - '0');
                    index[0]++;
                }
                node = new TreeNode(val*num);
                num = 1;
            }
        }
        return node;
    }
}
