class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) {
            return true;
        }
        if(t == null || t.length() == 0 || s.length() > t.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        if(i== s.length() && j <= t.length()){
            return true;
        }
        return false;
    }
}
//follow up:
//If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
//and you want to check one by one to see if T has its subsequence.
//In this scenario, how would you change your code?

// put t into the map,which map<t[i], List<Index>>
// check s[i] in the map and it has the index that after its prev index
// which make its a valid subsequence
//T: (KM*logN) S: O(N)
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }

        int pre = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(s.charAt(i))) {
                return false;
            }
            List<Integer> list = map.get(c);
            int cur = binarySearch(list, pre);
            if(cur == pre) {
                return false;
            }
            pre = cur;
        }
        return true;
    }
    // find the first element that bigger than the pre index
    private int binarySearch(List<Integer> list, int pre) {
        int i = 0;
        int j = list.size() - 1;
        while(i < j -1) {
            int m = i + (j - i) / 2;
            // remove i if == pre or smaller than pre
          if(list.get(m) <= pre) {
                 i = m+1;

            }else if(list.get(m) > pre) {
                j = m;
            }
        }
        if(list.get(i) > pre) {
            pre = list.get(i);
        }else if(list.get(j) > pre) {
            pre = list.get(j);
        }
        return pre;
    }
