class Solution {
    public int superpalindromesInRange(String left, String right) {
      // due to the max 10^18, so the half of i is max 10^5
        //build the palindromes one by one
        // ex: [1,10]
        // 1 => odd: 1 even: 11 => calcuate the square 1, 11*11, if the square is palindrome and ins the scope, res++
        long min = (long)(Long.parseLong(left)*1.0);
        long max = (long)(Long.parseLong(right)*1.0);
        int res = 0;
        for(long i = 1; i <= 100000; i++){
            long[] can = generate(i);
            if(can[0] <= max && can[0] >= min && isP(can[0])){
                res++;
            }
            if(can[1] <= max && can[1] >= min && isP(can[1])){
                res++;
            }
            if(can[1] > max && can[0] > max){
                break;
            }
        }
        return res;
    }
    private long[] generate(long i){
        long[] res = new long[2];
       String s1 = String.valueOf(i);
       StringBuilder odd = new StringBuilder();
       StringBuilder even = new StringBuilder();
       int index = s1.length()-1;
       while(index-1 >= 0){
           odd.append(s1.charAt(index-1));
           index--;
       }
        index = s1.length()-1;
       while(index >=0){
           even.append(s1.charAt(index));
           index--;
       }
       String oddS = s1+ odd.toString();
       res[0] = Long.parseLong(oddS)*Long.parseLong(oddS);
       String evenS = s1 + even.toString();
        res[1] = Long.parseLong(evenS)*Long.parseLong(evenS);
        return res;
    }
    private boolean isP(long i){
        String s= String.valueOf(i);
        int left = 0;
         int right = s.length() -1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
