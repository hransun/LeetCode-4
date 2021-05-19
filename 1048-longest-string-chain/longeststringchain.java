class Solution {
    public int longestStrChain(String[] words) {
        // sort the length from short to long
        // generate the possible list which is one letter miss, match with the ones before it
        // get the biggest number
        //dp[i]: the longest chain that end at the cur word
        Arrays.sort(words, (a,b) -> (a.length() - b.length())); //T: nlogn
        int res = 1;
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        for(int i = words.length-1 ; i > 0; i--){ //T: O(n*n)
            List<String> list = generatePossible(words[i]); // T: L*L S: O(list)
            for(int j = i -1; j >= 0; j--) {
                if(words[j].length() + 1 == words[i].length() && list.contains(words[j])) {
                    dp[j] = Math.max(dp[i]+1, dp[j]);
                    res = Math.max(dp[j], res);
                }
            }
        }
        return res;
    }
    private List<String> generatePossible(String s){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length() ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < s.length(); j++) {
                if(i == j){
                    continue;
                }
                sb.append(s.charAt(j));
            }
           // String temp = sb.tostring();
            list.add(sb.toString());
        }
        return list;
    }
}
