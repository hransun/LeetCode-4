class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(S, res, sb, 0);
        return res;
    }
    private void dfs(String s, List<String> res, StringBuilder sb, int index){
        if(index == s.length()){
            res.add(new String(sb));
            return;
        }
        char cur = s.charAt(index);
        if(Character.isLetter(cur)){
            dfs(s,res, sb.append(Character.toLowerCase(cur)),index+1);
            sb.deleteCharAt(sb.length()-1);
            dfs(s,res, sb.append(Character.toUpperCase(cur)),index+1);
            sb.deleteCharAt(sb.length()-1);
        }else{
            dfs(s,res,sb.append(cur),index+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
