class Solution {
    public boolean isStrobogrammatic(String num) {
        //step 1: change the num to the reverse one ex: 6->9; 9->6,1->1. 8->8, 0->0
        //step 2: reverse the string ,if it's the same, then it's strobogrammatic number.
        StringBuilder sb = new StringBuilder();
        for(char c: num.toCharArray()){
            if(c == '6'){
                sb.append('9');
            }else if(c == '9'){
                sb.append('6');
            }else if(c == '1' || c == '0' || c == '8'){
                sb.append(c);
            }else{
                return false;
            }
        }
        return num.equals(sb.reverse().toString());

    }
}
