class Solution {
    public String originalDigits(String s) {
        //find the unique char in each digit
        // 'z' -> zero; 'w'->two;'u' -> four, 'x'->six,'g'->'eight'
        // h -> three & eight -> number of h - number of eight = number of three
        //f -> five&&four ...
        //s -> seven && six ...
        //i -> nine five, six ,eight
        // n -> one, seven, nine*2(有两个n)
        //因为所有的字母是正好配对
        StringBuilder sb = new StringBuilder();
        int[] digit = new int[10];
        int[] base = new int[26];
        for(char c: s.toCharArray()){
            base[c-'a']++;
        }
        digit[0] = base['z' -'a'];
        digit[2] = base['w'-'a'];
        digit[4] = base['u'-'a'];
        digit[6] = base['x'-'a'];
        digit[8] = base['g'-'a'];
        digit[3] = base['h'-'a'] - digit[8];
        digit[5] = base['f'-'a'] - digit[4];
        digit[7] = base['s'-'a'] - digit[6];
        digit[9] = base['i'-'a'] - digit[5] - digit[6] - digit[8];
        digit[1] = base['n'-'a'] - digit[7] - digit[9]*2;
        for(int i = 0; i < digit.length; i++){
            while(digit[i] > 0){
                digit[i]--;
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
