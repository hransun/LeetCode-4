class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
      //on the base case, check the path is valid palindrome
      // a valid palindrome: only has one odd value
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[]{0};
        helper(root, map, res);
        return res[0];
    }
    private void helper(TreeNode root, Map<Integer,Integer> map, int[] res){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            map.put(root.val, map.getOrDefault(root.val,0)+1);
            if(valid(map)){
                res[0]++;
            }
            int value = map.get(root.val);
            map.put(root.val, value-1);
            return;
        }
        map.put(root.val, map.getOrDefault(root.val,0)+1);
        helper(root.left, map, res);
        helper(root.right, map, res);
        int value = map.get(root.val);
        map.put(root.val, value-1);
    }
    private boolean valid(Map<Integer,Integer> map){
        boolean once = false;
            for(Map.Entry entry: map.entrySet()){
                int value = (int)entry.getValue();
                if(value%2 == 1){
                    if(!once){
                        once = true;
                    }else{
                        return false;
                    }
                }
            }
        return true;
    }
}
