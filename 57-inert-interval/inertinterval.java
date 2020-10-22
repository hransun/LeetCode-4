class Solution {
    //如果在新区间的左边，直接copy pair
    //如果和新区间开始出现重叠，更新新区间的左右边界
    //如果在新区间的右边，将新区间copy 进list， 把现在的区间作为新区间
    //之后可以重用code
    //post condition
    //把最后一个新区间coopy 进list
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for(int[] pair: intervals){
          //cur pair在新的interval右边，且没有交集，直接加入list
            if(pair[1] < newInterval[0]){
                list.add(pair);
                continue;
            }
            //cur pair 在新的interval左边，且没有交集，new Interval加入， 跟新cur 为newInterval
            if(pair[0] > newInterval[1]){
                list.add(newInterval);
                newInterval = pair;
                continue;
            }
            //cur pair和interval有交集，直接更新左右边界
            newInterval[0] = Math.min(newInterval[0], pair[0]);
            newInterval[1] = Math.max(newInterval[1], pair[1]);
        }
        //post condition，把最后一个interval加入
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
