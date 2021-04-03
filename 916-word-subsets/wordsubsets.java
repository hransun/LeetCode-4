class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] map = new int[26];
        for(String s: B){
            int[] temp = new int[26];
            for(char c: s.toCharArray()){
                //especial case for
                //["amazon","apple","facebook","google","leetcode"]
                //["eo","lo"] => int[o] = 1 ==> list:["google","leetcode"]
                temp[c -'a'] += 1;
                map[c-'a'] = Math.max(map[c-'a'], temp[c-'a']);
            }
        }
        List<String> list = new ArrayList<>();
        for(String s:A){
            int[] a = new int[26];
            for(char c: s.toCharArray()){
               a[c-'a'] += 1;
            }
            boolean flag = true;
            for(int i = 0; i < 26; i++){
                if(map[i] != 0 && map[i] > a[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.add(s);
            }
        }
        return list;
    }
}
