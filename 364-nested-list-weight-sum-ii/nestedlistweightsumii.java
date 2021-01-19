/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        //List<Integer>: 每一层index代表其层数，最开始的index代表最外层，所以需要从后往前render
        List<Integer> list = new ArrayList<>();
        helper(nestedList,0,list);
        int level = 1;
        int sum = 0;
        for(int i = list.size()-1; i >= 0; i--){
            sum += list.get(i)*level;
            level++;
        }
        return sum;
    }
    private void helper(List<NestedInteger> array, int level, List<Integer> list){
        //初始化list，没有碰到的level,先初始化为0
        if(level >= list.size()){
            list.add(0);
        }
        for(NestedInteger i: array){
            if(i.isInteger()){
                int sum = i.getInteger() + list.get(level);
                list.set(level, sum);
            }else{
                helper(i.getList(), level+1, list);
            }
        }
    }
}
