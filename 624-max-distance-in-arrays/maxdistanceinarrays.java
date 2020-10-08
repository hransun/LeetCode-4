class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        //每一次只更新一边的和globally最小/最大的值差
        int min = arrays.get(0).get(0);
        int max= arrays.get(0).get(arrays.get(0).size()-1);
        int res = 0;
        for(int i = 1; i < arrays.size();i++){
            res = Math.max(res, Math.max(Math.abs(arrays.get(i).get(0) - max), Math.abs(arrays.get(i).get(arrays.get(i).size()-1) - min)));
            //update min and max
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
        }
        return res;

    }
}
