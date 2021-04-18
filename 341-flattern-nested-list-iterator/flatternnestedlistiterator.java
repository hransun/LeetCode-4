/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
        List<Integer> list;
        int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = nextList(nestedList);
        index = 0;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return list.get(index++);
        }
        return null;

    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
    private List<Integer> nextList(List<NestedInteger> nestedList){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nestedList.size(); i++){
            NestedInteger cur = nestedList.get(i);
            if(cur.isInteger()){
                list.add(cur.getInteger());
            }else{
                List<Integer> temp = nextList(cur.getList());
                for(Integer t: temp){
                    list.add(t);
                }
            }
        }
        return list;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
