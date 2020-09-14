class Solution {
        //bijection需要一一对应，需要两个map
    //in case: aaaa dog cat cat dog出现
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> m1 = new HashMap<>();
         Map<String, Character> m2 = new HashMap<>();
        String[] array = str.split(" ");
        int i = 0;
        int j = 0;
        while(i < pattern.length() && j < array.length) {
            String s = array[j];
            char c = pattern.charAt(i);
            if(m1.containsKey(c)) {
                if(!s.equals(m1.get(c))) {
                    return false;
                }
            }else{
                m1.put(c, s);
            }
            if(m2.containsKey(s)) {
                if(c != m2.get(s)) {
                    return false;
                }
            }else{
                m2.put(s, c);
            }

            i++;
            j++;
        }
        return i == pattern.length() && j == array.length;
    }

}
