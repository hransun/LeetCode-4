class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        //case1: the same
        //case2: no case sensetivie
        //case3: don't vare vowels
        String[] res = new String[queries.length];
        //case1: the same
        Set<String> case1 = new HashSet<>();
        // for case 2: Map<big case, the first string that can transfer to the key>
        Map<String, String> case2 = new HashMap<>();
        // for case 3: Map<remove vowel, the fist string that can tranfer to the key>
        Map<String, String> case3 = new HashMap<>();
        for(String s: wordlist){
            if(case1.add(s)){
                String key = s.toUpperCase();
                if(!case2.containsKey(key)){
                    case2.put(key, s);
                }
                String noVowel = changeVowel(key);
                if(!case3.containsKey(noVowel)){
                    case3.put(noVowel, s);
                }
            }
        }
        Arrays.fill(res, "");
        for(int i = 0; i < res.length; i++){
            String s = queries[i];
            String big = s.toUpperCase();
            String noVowel = changeVowel(big);
            if(case1.contains(s)){
                res[i] = s;
            }else if(case2.containsKey(big)){
                res[i] = case2.get(big);
            }else if(case3.containsKey(noVowel)){
                res[i] = case3.get(noVowel);
            }
        }
        return res;
    }
    private String changeVowel(String s){
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c =='U'){
                sb.append('*');
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
