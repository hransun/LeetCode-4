class Solution {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0) {
            return true;
        }
      char[] array = word.toCharArray();
       int big = 0;
       int small = 0;
        for(int i = 0; i < array.length; i++) {
            char c = array[i];
            if(!isSmall(c)&&!isBig(c)) {
                return false;
            } else if(isSmall(c)) {
                if(big > 1) {
                    return false;
                }
                small++;
            }else if(isBig(c)) {
                if(small >= 1) {
                    return false;
                }
                big++;
            }
        }
        return true;
    }
    private boolean isSmall(char c) {
        return (c-'a') >= 0 && ('z'-c) <= 26;
    }
     private boolean isBig(char c) {
        return (c-'A') >= 0 && ('Z'-c) <= 26;
    }
}
