class Solution {
    public int numJewelsInStones(String J, String S) {
      //set
        //T: O(n) S: O(length of J)
        if(J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        Set<Character> set = builder(J);
        int count = 0;
        for(int i = 0; i < S.length(); i++) {
            if(set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    private Set<Character> builder(String J) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        return set;
    }
}
// array
public int numJewelsInStones(String J, String S) {
        //T: O(n + m) S: O(1)
        if(J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        //in the Ascii table, the scope of A - z is 58
        int[] array = new int[58];
        for(int i = 0; i < J.length(); i++) {
            array[J.charAt(i) - 'A'] = 1;
        }
        int res = 0;
        for(int i = 0; i < S.length(); i++) {
            res += array[S.charAt(i) - 'A'];
        }
        return res;
    }
