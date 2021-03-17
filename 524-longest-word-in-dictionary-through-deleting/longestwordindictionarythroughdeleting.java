class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a,b) ->{
            int com = b.length() -a.length();
            if(com == 0){
                com = a.compareTo(b);
            }
            return com;
        });
        for(String word: d){
             if(canForm(word, s)){
                 return word;
            }
        }

        return "";
    }
    private boolean canForm(String s1, String s2){
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;j++;
            }else{
                j++;
            }
        }
        return i == s1.length();
    }
}
