class Solution {
     public int[] numsSameConsecDiff(int n, int k) {
        if(n==1){
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            helper(n-1,k,0,i,list);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i <list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
    private void helper(int n, int k,int sum,int cur, List<Integer> list){
        if(cur < 0 || cur > 9) {
            return;
        }
         if(n == 0) {
           sum =sum*10 + cur;
            list.add(sum);
            return;
        }
        sum =sum*10 + cur;
        helper(n-1,k,sum,cur-k,list);
        if(k != 0) {
            helper(n-1,k,sum,cur+k,list);
        }
    }
}
