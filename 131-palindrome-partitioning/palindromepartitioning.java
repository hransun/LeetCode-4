class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        boolean[][] par = new boolean[s.length()][s.length()];
        helper(s,res,cur,0, par);
        return res;
    }
    private void helper(String s, List<List<String>> list, List<String> cur, int index, boolean[][] par){
        if(index == s.length()){
            List<String> temp = new ArrayList<>();
            for(String string: cur){
                temp.add(string);
            }
            list.add(temp);
            return;
        }
        for(int i = index; i< s.length(); i++){
            char c1 = s.charAt(index);
            char c2 = s.charAt(i);
            if(c1 == c2 && (i-index <= 2 || par[index+1][i-1])){
                par[index][i] = true;
                cur.add(s.substring(index,i+1));
                helper(s,list,cur, i+1, par);
                cur.remove(cur.size()-1);
            }
        }
    }
}
