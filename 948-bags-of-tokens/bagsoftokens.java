class Solution {
    public int bagOfTokensScore(int[] tokens, int p) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Arrays.sort(tokens);
        int max = 0;
        int s = 0;
        int j = tokens.length - 1;
        int i = 0;
        while(i <= j){
            // add scores
            if(p >= tokens[i]){
                p -=tokens[i++];
                s++;
            // decrease scroes and add power
            }else if(p < tokens[i] && s > 0){
                p += tokens[j--];
                s--;
            // if score == 0， move to next element to check
            }else{
                i++;
            }
            //each around up the max score
            max= Math.max(s,max);
        }
        return max;
    }
}
