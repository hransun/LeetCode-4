class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        //graph
        //time: 2 ^ height
        //space: height
        List<Integer> list = new ArrayList<>();
        dfs(x,y,0.0,0.0,bound, list);
        return list;
    }
    private void dfs(int x, int y, double i, double j, int bound, List<Integer> list){
        int cur = (int)(Math.pow(x,i) + Math.pow(y,j));
        if(cur > bound){
            return;
        }
        if(!list.contains(cur)){
            list.add(cur);
        }
        if(x > 1){
            dfs(x,y,i+1,j, bound, list);
        }
        if(y > 1){
            dfs(x,y,i,j+1, bound, list);
        }
    }
}
//for loop
//time: O(n*m)
List<Integer> list = new ArrayList<>();
        int n = (int)(Math.log(bound)/Math.log(x));
        int m =  (int)(Math.log(bound)/Math.log(y));
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                int cur = (int)(Math.pow(x,i) + Math.pow(y,j));
                if(cur <= bound && !list.contains(cur)){
                    list.add(cur);
                }
                // if y == 1, only need to for loop once
                if(y == 1){
                    break;
                }
            }
            // if x == 1, only need to for loop once
            if(x == 1){
                break;
            }
        }
        return list;
