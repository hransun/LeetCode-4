class Solution {
    public int totalNQueens(int n) {
        List<Integer> list = new ArrayList<>();
        return dfs(n,0,list);
    }
    private int dfs(int n ,int row, List<Integer> list){
        if(row == n){
            return 1;
        }
        int sum = 0;
        for(int i = 0 ; i< n; i++){
            if(isValid(row, i, list)){
                list.add(i);
                sum +=dfs(n,row+1, list);
                list.remove(list.size()-1);
            }
        }
        return sum;
    }
    private boolean isValid(int row, int position, List<Integer> list){
        for(int i= 0; i < list.size(); i++){
            if(list.get(i) == position || (row-i) == Math.abs(list.get(i)-position)){
                return false;
            }
        }
        return true;
    }
}
