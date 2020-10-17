class Solution {
    public boolean buddyStrings(String A, String B) {
          if(A.length() != B.length()){
            return false;
        }
        int diff = 0;
        Set<Character> set = new HashSet<>();
        char[] g1 = new char[2];
        char[] g2 = new char[2];
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) != B.charAt(i)){
                if(diff == 2){
                    return false;
                }
                g1[diff] = A.charAt(i);
                g2[diff] = B.charAt(i);
                diff++;
            }
            set.add(A.charAt(i));
        }
        if(diff == 1){
            return false;
        }
        //如果A，B没有相同，查看是否有duplicated letter, ie aa,aa return true
        if(diff == 0){
            return set.size() < A.length();
        }
        return g1[0] == g2[1] && g1[1] == g2[0];
    }
}
