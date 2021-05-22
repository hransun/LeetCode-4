class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for(String s: words){
            if(s.length() == pattern.length()) {
                if(compare(pattern, s)){
                    list.add(s);
                }
            }
        }
        return list;
    }
    private boolean compare(String s1, String s2) {
        Map<Character, Character> m1 = new HashMap<>();
        Map<Character,Character> m2 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(!m1.containsKey(c1)) {
                m1.put(c1,c2);
            }
            if(!m2.containsKey(c2)){
                m2.put(c2,c1);
            }
            if(m1.get(c1) != c2 ||m2.get(c2) != c1) {
                return false;
            }
        }
        return true;
    }

}
