class Solution {
  //extra space
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
         StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(String s: word1){
            sb1.append(s);
        }
        for(String s: word2){
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }
    //T: O(n) S: O(1)
         int l1 = 0;
       int l2 = 0;
       for(String s: word1){
           l1 += s.length();
       }
       for(String s: word2){
           l2 += s.length();
       }
       if(l1 != l2){
           return false;
       }
       int index = 0;
       //代表走到第几个array
       int r1 = 0;
       int r2 = 0;
       //代表之前几个array element的size
       int c1 = 0;
       int c2 = 0;
       while(index < l1){
            if(word1[r1].charAt(index-c1) != word2[r2].charAt(index-c2)){
                return false;
            }
           index++;
           if(word1[r1].length() == index-c1){
               c1 += word1[r1].length();
               r1++;
           }
            if(word2[r2].length() == index-c2){
               c2 += word2[r2].length();
               r2++;
           }

       }
       return true;

   }
}
