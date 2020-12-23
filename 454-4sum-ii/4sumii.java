class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
           Map<Integer, Integer> abSums = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                abSums.merge(a + b, 1, Integer::sum);
            }
        }

        int count = 0;
        for (int c : C) {
            for (int d : D) {
                count += abSums.getOrDefault(- (c + d), 0);
            }
        }
        return count;
    }

}
