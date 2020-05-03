class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //T: O(n+m) S: O(1)
        if((magazine == null || magazine.length() == 0) && (ransomNote == null || ransomNote.length() == 0)) {
            return true;
        }
        if(magazine == null || magazine.length() == 0) {
            return false;
        }
        if(ransomNote == null || ransomNote.length() == 0) {
            return true;
        }

        int[] set = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            set[magazine.charAt(i) - 'a'] += 1;
        }
        for(int i = 0; i<ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if(set[index] == 0) {
                return false;
            }else {
                set[index] -= 1;
            }
        }
        return true;
    }
}
