class Solution {
    public String toGoatLatin(String s) {
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i <array.length;i++){
            String cur = array[i];
            char start = cur.charAt(0);
            char[] temp = cur.toCharArray();
            if(vowel(start)){
                sb.append(cur);
            }else{
                for(int j = 1; j < temp.length; j++) {
                    sb.append(temp[j]);
                }
                sb.append(temp[0]);
            }
            sb.append("ma");
            for(int k = 0; k<= i;k++) {
                sb.append('a');
            }
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    //(a, e, i, o, or u
    private boolean vowel(char c){
        return c == 'a' || c == 'A' ||c == 'e' ||c == 'E'||c == 'I' ||c == 'i' ||c == 'o'||c == 'O'
            ||c == 'U'||c == 'u';
    }
