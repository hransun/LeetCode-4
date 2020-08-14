class CombinationIterator {
    List<String> list = new ArrayList<>();
    int i;
    public CombinationIterator(String characters, int combinationLength) {
        dfs(characters, combinationLength, list, new StringBuilder(), 0);
        Collections.sort(list);
        i = 0;
    }

    public String next() {
        if(!hasNext()) {
            return null;
        }
        return list.get(i++);
    }

    public boolean hasNext() {
        return i < list.size();
    }
    private void dfs(String s, int k, List<String> list, StringBuilder sb, int index) {
        if(index == s.length() &&sb.length() == k || sb.length() == k ) {
            list.add(sb.toString());
            return;
        }
        if(index == s.length()){
            return;
        }
        dfs(s,k,list,sb,index+1);
        sb.append(s.charAt(index));
        dfs(s,k,list,sb, index+1);
        sb.deleteCharAt(sb.length()-1);
    }
}
