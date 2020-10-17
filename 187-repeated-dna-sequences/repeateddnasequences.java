class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        //set: the collection for the different substring
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length()- 9;i++){
            String cur = s.substring(i,i+10);
            //if the substring has seen before and it's not the result
            if(!set.add(cur) && !list.contains(cur)){
                list.add(cur);
            }
        }
        return list;
    }
}
