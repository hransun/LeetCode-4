class Solution {
    public boolean checkValidString(String s) {
       if(s == null || s.length() == 0) {
           return true;
       }
        //leftbalance
        //consider * = (
        int count = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '*') {
                count++;
            }else{
                count--;
            }
            // if ) is before "(" or "*"
            if(count < 0) {
                return false;
            }
        }
        if(count == 0) {
            return true;
        }
        //rightbalance
        //consider * = )
        count = 0;
        for(int i = s.length()-1; i>=0;i--) {
            if(s.charAt(i) == ')' || s.charAt(i) == '*') {
                count++;
            }else{
                count--;
            }
            if(count < 0) {
                return false;
            }
        }
        return true;

    }
}
