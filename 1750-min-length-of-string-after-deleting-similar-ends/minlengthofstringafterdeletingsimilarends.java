class Solution {
    public int minimumLength(String s) {
        //two pointer
        // if the same, move on
        int i = 0;
        int j = s.length()-1;
        //ex: aaaba -> return 1
        while(i<j && s.charAt(i) == s.charAt(j)){
            char t = s.charAt(i);
            //ex: aaaaaaa ==> return 0
            while(i <= j && (s.charAt(i) == t || s.charAt(j) == t)){
                if(s.charAt(i) == t){
                    i++;
                }
                if(s.charAt(j) == t){
                    j--;
                }
            }
        }
        //ex: aaaaaaa ==> return 0
        if(i > j){
            return 0;
        }
        return j-i+1;
    }
}
