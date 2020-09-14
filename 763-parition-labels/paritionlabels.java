class Solution {
   //记录每一个letter最后出现的index
    //partition的地方就是这一段里最后出现的index的地方和current index重合的地方并且是最大的index
    //ex: abab| c| f
    //    2323  4  5
    //T: O(n) S: O(1)
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] array = new int[26];
        for(int i = 0 ; i< S.length();i++) {
            char c = S.charAt(i);
            array[c-'a'] = i;
        }
        int begin = 0;
        int maxIndex = -1;
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int curIndex = array[c-'a'] ;
            maxIndex = Math.max(maxIndex, curIndex);
            if(curIndex == i && curIndex == maxIndex) {
                res.add(i-begin+1);
                begin = i+1;
            }

        }
        return res;
    }
}
