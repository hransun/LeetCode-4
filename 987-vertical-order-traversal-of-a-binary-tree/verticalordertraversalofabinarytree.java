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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //最上面，最左边的排最前面
        //col,row相同，看val
        //Map<col, int[row, val]>
        Map<Integer, List<int[]>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int[] min = new int[]{0};
        int[] max = new int[]{0};
        dfs(root, map, 0, 0,min,max);
        for(int i = min[0]; i <= max[0]; i++){
            List<int[]> list = map.get(i);
            Collections.sort(list, (a, b)->{
                int com = a[0]-b[0];
                if(com == 0){
                    com = a[1]-b[1];
                }
                return com;
            });
            List<Integer> temp = new ArrayList<>();
            for(int pair[]:list){
                temp.add(pair[1]);
            }
            res.add(temp);
        }
        return res;
    }
    private void dfs(TreeNode root, Map<Integer, List<int[]>> map, int col,int row, int[] min, int[] max){
        if(root == null){
            return;
        }
        if(!map.containsKey(col)){
            map.put(col, new ArrayList<>());
        }
        map.get(col).add(new int[]{row,root.val});
        //在走的过程中就要随时跟新min/max， incase 在中间的情况下出现最值
        min[0] = Math.min(min[0],col);
        max[0] = Math.max(max[0], col);
        dfs(root.left, map, col-1, row+1, min, max);
        dfs(root.right, map, col+1, row+1, min, max);
    }
}
