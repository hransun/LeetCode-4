class Solution {
    public List<String> letterCombinations(String digits) {
        //dfs: 7 和 9多一位
        List<String> list = new ArrayList<>();
        if(digits.length() == 0){
            return list;
        }
        dfs(digits,0, new StringBuilder(), list);
        return list;
    }
    private void dfs(String s, int index, StringBuilder sb, List<String> list){
        if(index == s.length()){
            String temp = sb.toString();
            list.add(temp);
            return;
        }
        char c = s.charAt(index);
        int diff = c -'2';
        int max = 3;
        int addOn = 3*diff;
        if(diff == 5 || diff == 7){
            max = 4;
        }
        if(diff > 5){
            addOn++;
        }
        for(int i = 0; i < max; i++){
            char letter = (char)('a'+i+addOn);
            sb.append(letter);
            dfs(s,index+1,sb,list);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
