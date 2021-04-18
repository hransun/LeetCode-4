class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('A');
        vowels.add('e'); vowels.add('E');
        vowels.add('i'); vowels.add('I');
        vowels.add('o'); vowels.add('O');
        vowels.add('u'); vowels.add('U');
        int half = 0;
        for(int i = 0; i < s.length()/2; i++){
            if(vowels.contains(s.charAt(i))){
                half++;
            }
        }
        for(int i = s.length()-1; i>= s.length()/2; i--){
            if(vowels.contains(s.charAt(i))){
                half--;
            }
        }
        return half == 0;
    }
}
