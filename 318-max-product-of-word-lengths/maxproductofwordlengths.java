class Solution {
    public int maxProduct(String[] words) {
        Arrays.sort(words, (a,b) -> b.length()- a.length());
        int res = 0;
        for(int i = 0; i < words.length-1; i++){
            Set<Character> set = new HashSet<>();
            for(char c: words[i].toCharArray()) {
                    set.add(c);
                }
            for(int j = i+1; j <words.length; j++){
                boolean flag = false;
                for(char c : words[j].toCharArray()) {
                    if (set.contains(c)){
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    res = Math.max(res, words[i].length() * words[j].length());
                    break;
                }
            }
        }
        return res;
    }
}
