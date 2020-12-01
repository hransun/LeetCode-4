class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] base = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(String s: words){
            set.add(trans(s, base));
        }
        return set.size();
    }
    private String trans(String s, String[] base){
        String res = "";
        for(Character c: s.toCharArray()){
            int num = c - 'a';
            res += base[num];
        }
        return res;
    }
}
