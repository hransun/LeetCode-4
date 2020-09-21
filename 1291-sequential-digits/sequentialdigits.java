class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String base = "123456789";
        List<Integer> list = new ArrayList<>();
        int min = String.valueOf(low).length();
        int max = String.valueOf(high).length();
        for(int i = min; i <= max; i++){
            for(int j = 0; j <= base.length()-i;j++){
                int cur = Integer.valueOf(base.substring(j,j+i));
                if(cur >= low && cur <= high){
                    list.add(cur);
                }
            }
        }
        return list;

    }
}
