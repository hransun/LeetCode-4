class Solution {
    public int findJudge(int N, int[][] trust) {
        //T: O(n) S: O(n)
        //count[i] represnt how many people trust this person - the number of people this person trust
         int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
}
