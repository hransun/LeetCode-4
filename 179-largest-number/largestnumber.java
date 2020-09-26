class Solution {
    public String largestNumber(int[] nums) {
        String[] array = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            array[i] = nums[i]+"";
        }
        Arrays.sort(array, (a,b) -> (b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for(String i: array){
            sb.append(i);
        }
        //corner case: 0,0
        if(sb.charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }

}
