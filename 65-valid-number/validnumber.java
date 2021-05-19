class Solution {
    public boolean isNumber(String s) {
        boolean seeNum = false;
        boolean seeDot = false;
        boolean seeE = false;
        for(int i = 0 ; i < s.length() ;i++) {
            char c = s.charAt(i);
            //dot: only visited once, can't be behind E
            if(c == '.'){
                if(seeDot || seeE){
                    return false;
                }
                seeDot = true;
            // E/e: only once, must behind number
            // once see E, re -recorder, because after E, can consider to valid a new int
            }else if(c == 'E' || c == 'e'){
                if(seeE || !seeNum){
                    return false;
                }
                seeE = true;
                seeNum = false;
            //leading position or position behind e/E
            // once see sign, re -recorder, because after E, can consider to valid a new int
            }else if(c == '-' || c == '+'){
                if(i != 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E'){
                    return false;
                }
                seeNum = false;
            }else if(Character.isDigit(c)) {
                seeNum = true;
            }else{
                return false;
            }
        }
        return seeNum;
    }
}
