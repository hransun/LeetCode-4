class Solution {
    public int romanToInt(String s) {
        // T: O(n)
        int res = 0;
        int index =0;
        while(index < s.length()){
            char cur = s.charAt(index);
            if(cur =='I'){
                if(index+1 < s.length() && s.charAt(index+1) == 'V'){
                    res += 4;
                    index += 2;
                }else if(index+1 < s.length() &&s.charAt(index+1) == 'X'){
                    res += 9;
                    index += 2;
                }else{
                    res += 1;
                    index++;
                }
            }else if(cur == 'V'){
                res += 5;
                index++;
            }else if(cur == 'X'){
                if(index+1 < s.length() && s.charAt(index+1) == 'L'){
                    res += 40;
                    index += 2;
                }else if(index+1 < s.length() &&s.charAt(index+1) == 'C'){
                    res += 90;
                    index += 2;
                }else{
                    res += 10;
                    index++;
                }
            }else if (cur == 'L'){
                res += 50;
                index++;
            }else if(cur == 'C'){
                if(index+1 < s.length() && s.charAt(index+1) == 'D'){
                    res += 400;
                    index += 2;
                }else if(index+1 < s.length() &&s.charAt(index+1) == 'M'){
                    res += 900;
                    index += 2;
                }else{
                    res += 100;
                    index++;
                }
            }else if(cur == 'D'){
                res += 500;
                index++;
            }else if(cur == 'M'){
                res += 1000;
                index++;
            }
        }
        return res;
    }
}
