class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(n, res,0, cur);
        return res;
    }
    private void dfs(int n, List<List<String>> res, int level, List<Integer> cur) {
        if(level == n){
            List<String> temp = new ArrayList<>();
            for(int k: cur){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < n; i++){
                    if(k == i) {
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        }
        for(int i = 0; i < n; i++){
            if(canPut(i,cur)) {
                cur.add(i);
                dfs(n,res, level+1, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    private boolean canPut(int location,List<Integer> list){
        for(int i = 0; i < list.size() ;i++){
            if(list.get(i) == location || list.size() - i == Math.abs(location - list.get(i)) ) {
                return false;
            }
        }
        return true;
    }
}
